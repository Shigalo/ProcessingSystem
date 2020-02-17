package by.bsuir.shabanovich.Entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    public Delivery(Integer count, Waybill waybill, Nomenclature nomenclature) {
        this.count = count;
        this.waybill = waybill;
        this.nomenclature = nomenclature;
    }

    public Delivery() { }
}
