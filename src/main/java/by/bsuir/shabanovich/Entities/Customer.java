package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private Payment payment;

    private String name;
    private String address;

    @Column(name = "send_date")
    private LocalDate sendDate;

    public String getSend() { return (sendDate == null) ? "Заказ не отправлен" : sendDate.toString(); }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        sendDate = null;
        payment = null;
    }

    public Customer() {
    }
}

