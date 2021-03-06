package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Nomenclature;
import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByOrder(Order order);

    List<Product> findByNomenclatureOrderByOrderAscNomenclature(Nomenclature nomenclature);

}
