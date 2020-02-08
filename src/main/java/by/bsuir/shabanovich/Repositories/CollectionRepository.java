package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Collection;
import by.bsuir.shabanovich.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    public Collection findById(Integer id);

    @Transactional
    void deleteById(Integer id);
}
