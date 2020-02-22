package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ordering")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    String status;
    Double sum;

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "ready_date")
    private LocalDate readyDate;
    @Column(name = "send_date")
    private LocalDate sendDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Worker manager;

    public Order(LocalDate startDate, Worker manager) {
        this.startDate = startDate;
        this.manager = manager;
        status = "Отправлена";
    }

    public Order() { }

    public String getReady() { return (readyDate == null) ? "Заказ не готов" : readyDate.toString(); }

    public String getSend() { return (sendDate == null) ? "Заказ не отправлен" : sendDate.toString(); }
}
