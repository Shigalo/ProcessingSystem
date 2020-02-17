package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Waybill {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Double sum;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Waybill(Double sum, LocalDate date, Worker worker) {
        this.sum = sum;
        this.date = date;
        this.worker = worker;
    }

    public Waybill() {
    }
}
