package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    public Worker findById(Integer id);

    public Worker findByLogin(String login);

    @Transactional
    void deleteById(Integer id);
}
