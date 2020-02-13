package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Nomenclature {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String article;
    private String factory;
    private Double wholesale;
    private Double retail;
    private String collection;

    public Nomenclature(String name, String article, String factory, Double wholesale, Double retail, String collection) {
        this.name = name;
        this.article = article;
        this.factory = factory;
        this.wholesale = wholesale;
        this.retail = retail;
        this.collection = collection;
    }

    public Nomenclature() {
    }
}
