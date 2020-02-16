package by.bsuir.shabanovich.Entities;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    LocalDate date;
    String factory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    public Delivery(LocalDate date, String factory, Waybill waybill) {
        this.date = date;
        this.factory = factory;
        this.waybill = waybill;
    }

    public Delivery() { }
}
