package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.*;
import by.bsuir.shabanovich.Repositories.NomenclatureRepository;
import by.bsuir.shabanovich.Repositories.OrderRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Date date = new Date();

        Order order = new Order(date, manager);
        order = orderRepository.save(order);
        for(int i = 0; i < nomenclatureId.length; i++) {
            Integer ordered = nomenclatureCount[i];
            Nomenclature nomenclature = nomenclatureRepository.findById(nomenclatureId[i]);
            Product product = new Product(ordered, order, nomenclature);
            productRepository.save(product);
        }
    }

    public List<Product> findProducts(Integer id) {
        Order order = orderRepository.findById(id);
        return productRepository.findByOrder(order);
    }

}
