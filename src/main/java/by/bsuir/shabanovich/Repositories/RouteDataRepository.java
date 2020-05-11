package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Route;
import by.bsuir.shabanovich.Entities.RouteData;
import by.bsuir.shabanovich.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RouteDataRepository extends JpaRepository<RouteData, Long> {

    List<RouteData> findAllByRouteOrderByPosition(Route route);
}
