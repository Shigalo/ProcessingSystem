package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Entity(name = "ordering")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    Double sum;

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "ready_date")
    private LocalDate readyDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Worker manager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Integer position;

    public Order(LocalDate startDate, Worker manager) {
        this.startDate = startDate;
        this.manager = manager;
        setStatus(Status.PROCESSING);
    }

    public Order() { }

    public String getReady() { return (readyDate == null) ? "Заказ не готов" : readyDate.toString(); }

    public String getStatusText() {
        if(status == Status.READY) return "Собран";
        if(status == Status.PROCESSING) return "Обрабатывается";
        if(status == Status.DONE) return "Отправлен";
        return "Пользователь";
    }

    public String GetStatus() {
        if(status == Status.READY) return "Собран " + readyDate.toString();
        if(status == Status.DONE) return "Отправлен" + customer.getSendDate().toString();
        return "Обрабатывается";
    }
}
