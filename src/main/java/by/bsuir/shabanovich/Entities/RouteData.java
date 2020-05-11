package by.bsuir.shabanovich.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "route_data")
@Data
public class RouteData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    Integer position;

    public RouteData(Route route, Order order, Integer position) {
        this.route = route;
        this.order = order;
        this.position = position;
    }

    public RouteData() {
    }
}
