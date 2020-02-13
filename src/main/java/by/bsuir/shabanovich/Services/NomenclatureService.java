package by.bsuir.shabanovich.Services;

import by.bsuir.shabanovich.Entities.Nomenclature;
import by.bsuir.shabanovich.Repositories.NomenclatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomenclatureService {

    @Autowired
    NomenclatureRepository nomenclatureRepository;

    public List<Nomenclature> findAll() { return nomenclatureRepository.findAll(); }

    public Nomenclature findById(Integer id) {
        return nomenclatureRepository.findById(id);
    }

    public void deleteById(Integer id) {
        nomenclatureRepository.deleteById(id);
    }

    public void addNomenclature(String name, String factory, String collection, String wholesale, String retail, String article) {
        Double wholesaleDouble = Double.parseDouble(wholesale);
        Double retailDouble = Double.parseDouble(retail);

        Nomenclature nomenclature = new Nomenclature(name, article, factory, wholesaleDouble, retailDouble, collection);
        nomenclatureRepository.save(nomenclature);
    }

    public void editNomenclature(Integer id, String name, String factory, String count, String collection, String wholesale, String retail, String article) {
        Nomenclature nomenclature = nomenclatureRepository.findById(id);
        nomenclature.setName(name);
        nomenclature.setFactory(factory);
        nomenclature.setCollection(collection);
        nomenclature.setWholesale(Double.parseDouble(wholesale));
        nomenclature.setRetail(Double.parseDouble(retail));
        nomenclature.setArticle(article);
        nomenclatureRepository.save(nomenclature);
    }

    public void remove(Integer id) {
        nomenclatureRepository.deleteById(id);
    }
}
