package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "ordering")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Worker manager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;

    public Order(String data, Worker manager, Nomenclature nomenclature) {
        this.data = data;
        this.manager = manager;
        this.nomenclature = nomenclature;
    }

    public Order() {
    }
}
