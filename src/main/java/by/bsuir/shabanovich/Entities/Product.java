package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String factory;
    private Integer count;

    public Product(String name, String factory, Integer count) {
        this.name = name;
        this.factory = factory;
        this.count = count;
    }

    public Product() {
    }
}
