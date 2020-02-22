package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.*;
import by.bsuir.shabanovich.Repositories.NomenclatureRepository;
import by.bsuir.shabanovich.Repositories.OrderRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Integer id) { return orderRepository.findById(id); }

    public void addOrder(Integer[] nomenclatureId, Integer[] nomenclatureCount) {
        Worker manager = workerService.getCurrentUser();
        LocalDate date = LocalDate.now();

        Order order = new Order(date, manager);
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

}
