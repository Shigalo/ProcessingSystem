package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Nomenclature;
import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Product;
import by.bsuir.shabanovich.Repositories.OrderRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    void newSupply(Delivery delivery) {
        Nomenclature nomenclature = delivery.getNomenclature();
        List<Product> list = productRepository.findByNomenclatureOrderByOrderAscNomenclature(nomenclature);
        int count = delivery.getCount();

        for(Product p : list) {
            int need = p.getOrdered() - p.getDone();
            if(need > 0) {
                int done = Math.min(count, need);
                p.incerment(done);
                count -= done;
                productRepository.save(p);
            }
            if(count == 0)
                return;
        }

    }
}
