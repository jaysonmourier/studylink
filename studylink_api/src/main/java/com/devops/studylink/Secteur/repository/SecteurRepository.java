package com.devops.studylink.Secteur.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.Secteur.repository.entities.SecteurEntity;
import com.devops.studylink.Secteur.service.Secteur;

@Service
public class SecteurRepository {
    
    private final SecteurDao secteurDao;
    public SecteurRepository(SecteurDao s) {
        this.secteurDao = s;
    }
    public List<Secteur> getAll() {
        return secteurDao.findAll().stream().map(s -> new Secteur(s)).collect(Collectors.toList());
    }
    public Optional<Secteur> geyById(UUID id) {
        Optional<Secteur> result = this.secteurDao.findById(id).map(s -> new Secteur(s));
        return result;
    }
    public Secteur createSecteur(Secteur secteur) {
        return new Secteur(
            this.secteurDao.save(new SecteurEntity(secteur))
        );
    }
    public void delete(Secteur secteur) {
        SecteurEntity toDelete = new SecteurEntity(secteur);
        toDelete.setId(secteur.getId());
        secteurDao.delete(toDelete);
    }

}
