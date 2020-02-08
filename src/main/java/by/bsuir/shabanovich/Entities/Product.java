package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String article;
    private String factory;
    private Integer count;
    private Double wholesale;
    private Double retail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public Product(String name, String article, String factory, Integer count, Double wholesale, Double retail, Collection collection) {
        this.name = name;
        this.article = article;
        this.factory = factory;
        this.count = count;
        this.wholesale = wholesale;
        this.retail = retail;
        this.collection = collection;
    }

    public Product() {
    }
}
