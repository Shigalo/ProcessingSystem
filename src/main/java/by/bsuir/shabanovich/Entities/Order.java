package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ordering")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "ready_date")
    private Date readyDate;
    @Column(name = "send_date")
    private Date sendData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Worker manager;

    public Order(Date startDate, Worker manager) {
        this.startDate = startDate;
        this.manager = manager;
    }

    public Order() {
    }
}
