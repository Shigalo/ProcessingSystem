package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Collection;
import by.bsuir.shabanovich.Entities.Product;
import by.bsuir.shabanovich.Repositories.CollectionRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CollectionRepository collectionRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public void addProduct(String name, String factory, String count, String collection, String wholesale, String retail, String article) {
        Collection collectionObj = collectionRepository.findByName(collection);
        Integer countInt = Integer.parseInt(count);
        Double wholesaleDouble = Double.parseDouble(wholesale);
        Double retailDouble = Double.parseDouble(retail);

        Product product = new Product(name, article, factory, countInt, wholesaleDouble, retailDouble, collectionObj);
        productRepository.save(product);
    }

    public void editProduct(Integer id, String name, String factory, String count, String collection, String wholesale, String retail, String article) {
        Product product = productRepository.findById(id);
        product.setName(name);
        product.setFactory(factory);
        product.setCount(Integer.parseInt(count));
        product.setCollection(collectionRepository.findByName(collection));
        product.setWholesale(Double.parseDouble(wholesale));
        product.setRetail(Double.parseDouble(retail));
        product.setArticle(article);
        productRepository.save(product);
    }

    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
}
