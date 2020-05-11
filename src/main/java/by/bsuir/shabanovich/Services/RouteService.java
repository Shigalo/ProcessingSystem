package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.*;
import by.bsuir.shabanovich.Repositories.DeliveryRepository;
import by.bsuir.shabanovich.Repositories.RouteDataRepository;
import by.bsuir.shabanovich.Repositories.RouteRepository;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    RouteDataRepository routeDataRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    public Route create(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return routeRepository.save(new Route(localDate));
    }

    public void addToRoute(Route route, Integer[] data) {
        for(int i = 0; i < data.length;) {
            int position = data[i++];
            Order order = orderService.findById(data[i++]);
            RouteData routeData = new RouteData(route, order, position);
            routeDataRepository.save(routeData);
            order.setStatus(Status.DONE);
            Customer customer = order.getCustomer();
            customer.setSendDate(route.getSendDate());
            customerService.update(customer);
            orderService.update(order);
        }
    }

    public List<Route> findAll() {
        return routeRepository.findAllByOrderBySendDateDesc();
    }

    public Route findById(String id) {
        return routeRepository.findById(Integer.valueOf(id));
    }

    public List<RouteData> getData(Route route) {
        return routeDataRepository.findAllByRouteOrderByPosition(route);
    }
}
