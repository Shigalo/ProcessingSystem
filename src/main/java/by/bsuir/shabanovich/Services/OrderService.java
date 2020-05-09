package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.*;
import by.bsuir.shabanovich.Repositories.NomenclatureRepository;
import by.bsuir.shabanovich.Repositories.OrderRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    WorkerService workerService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    NomenclatureRepository nomenclatureRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerService customerService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findReady() {
        return orderRepository.findAllByStatus(Status.READY);
    }

    public Order findById(Integer id) { return orderRepository.findById(id); }

    public void addOrder(Integer[] nomenclatureId, Integer[] nomenclatureCount, String name, String address) {
        Customer customer = customerService.add(name, address);

        Worker manager = workerService.getCurrentUser();
        LocalDate date = LocalDate.now();

        Order order = new Order(date, manager);
        order.setCustomer(customer);
        order = orderRepository.save(order);

        double sum = 0;
        for(int i = 0; i < nomenclatureId.length; i++) {
            Integer ordered = nomenclatureCount[i];
            Nomenclature nomenclature = nomenclatureRepository.findById(nomenclatureId[i]);
            Product product = new Product(ordered, order, nomenclature);
            productRepository.save(product);
            sum += product.getOrdered() * nomenclature.getRetail();
        }
        order.setSum(sum);
        orderRepository.save(order);
    }

    public List<Product> findProducts(Integer id) {
        Order order = orderRepository.findById(id);
        return productRepository.findByOrder(order);
    }

    public void check() {
        List<Order> orderList = orderRepository.findAllByStatus(Status.PROCESSING);
        for(Order order : orderList) {
            List<Product> productList = productRepository.findByOrder(order);
            boolean ready = true;
            for(Product product : productList) {
                ready = product.getOrdered().equals(product.getDone());
                if(!ready) break;
            }
            if(ready) {
                LocalDate readyDate = LocalDate.now();
                order.setStatus(Status.READY);
                order.setReadyDate(readyDate);
                orderRepository.save(order);
            }
        }
    }

    public void remove(int id) {
        orderRepository.deleteById(id);
    }

}
