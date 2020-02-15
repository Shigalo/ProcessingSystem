package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer ordered;
    private Integer done;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    public Product(Integer ordered, Order order, Nomenclature nomenclature) {
        this.ordered = ordered;
        this.order = order;
        this.nomenclature = nomenclature;
        done = 0;
    }

    public Product() {
    }
}
