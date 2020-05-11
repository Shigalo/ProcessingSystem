package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Customer;
import by.bsuir.shabanovich.Entities.Delivery;
import by.bsuir.shabanovich.Entities.Payment;
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

    public Customer add(String name, String address, String payment) {
        Customer customer = new Customer(name, address);

        switch (payment) {
            case "card":    customer.setPayment(Payment.CARD); break;
            case "cash":    customer.setPayment(Payment.CASH); break;
            case "unknown": customer.setPayment(Payment.UNKNOWN); break;
        }
        customer = customerRepository.save(customer);
        return customer;
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
    }

}
