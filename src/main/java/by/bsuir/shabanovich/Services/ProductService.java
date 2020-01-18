package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Product;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
