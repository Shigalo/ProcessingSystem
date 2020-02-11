package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Collection;
import by.bsuir.shabanovich.Entities.Product;
import by.bsuir.shabanovich.Repositories.CollectionRepository;
import by.bsuir.shabanovich.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    public List<Collection> findAll() { return collectionRepository.findAll(); }

    public void deleteById(Integer id) {
        collectionRepository.deleteById(id);
    }

}
