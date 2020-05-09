package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Customer;
import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Waybill;
import by.bsuir.shabanovich.Repositories.CustomerRepository;
import by.bsuir.shabanovich.Repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer add(String name, String address) {
        Customer customer = new Customer(name, address);
        customer = customerRepository.save(customer);
        return customer;
    }

}
