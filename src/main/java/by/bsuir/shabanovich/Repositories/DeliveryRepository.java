package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    public Delivery findById(Integer id);

}
