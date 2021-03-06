package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findById(Integer id);

    public List<Order> findAllByStatus(Status status);

    @Transactional
    public void deleteById(int id);

}
