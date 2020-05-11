package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    public List<Route> findAllByOrderBySendDateDesc();

    public Route findById(Integer id);
}
