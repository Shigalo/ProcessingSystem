package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Customer;
import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
