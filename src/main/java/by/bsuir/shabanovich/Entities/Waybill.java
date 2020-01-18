package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Waybill {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Double sum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Waybill(Double sum, Worker worker) {
        this.sum = sum;
        this.worker = worker;
    }

    public Waybill() {
    }
}
