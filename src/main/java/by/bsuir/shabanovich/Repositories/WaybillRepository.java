package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaybillRepository extends JpaRepository<Waybill, Long> {
}
