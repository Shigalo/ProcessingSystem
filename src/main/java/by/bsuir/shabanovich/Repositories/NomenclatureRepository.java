package by.bsuir.shabanovich.Repositories;

import by.bsuir.shabanovich.Entities.Nomenclature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NomenclatureRepository extends JpaRepository<Nomenclature, Long> {

    public Nomenclature findById(Integer id);

    public Nomenclature findByArticle(String article);

    @Transactional
    void deleteById(Integer id);
}
