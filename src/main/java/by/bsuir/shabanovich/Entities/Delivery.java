package by.bsuir.shabanovich.Entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    Date date;
    String factory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    public Delivery(Date date, String factory, Waybill waybill) {
        this.date = date;
        this.factory = factory;
        this.waybill = waybill;
    }

    public Delivery() { }
}
