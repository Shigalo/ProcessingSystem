package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDate sendDate;

    public Route(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public Route() {
    }
}
