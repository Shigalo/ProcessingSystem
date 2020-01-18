package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Worker stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Order(String data, Worker stock, Product product) {
        this.data = data;
        this.stock = stock;
        this.product = product;
    }

    public Order() {
    }
}
