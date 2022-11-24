package com.devops.studylink.entreprise.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.Secteur.repository.SecteurDao;
import com.devops.studylink.Secteur.service.Secteur;
import com.devops.studylink.entreprise.repository.entities.EntrepriseEntity;
import com.devops.studylink.entreprise.service.Entreprise;

@Service
public class EntrepriseRepository {
    
    private final EntrepriseDao entrepriseDao;
    private final SecteurDao secteurDao;
    public EntrepriseRepository(EntrepriseDao e, SecteurDao s) {
        this.entrepriseDao = e;
        this.secteurDao = s;
    }
    public List<Entreprise> getAll() {
        return entrepriseDao.findAll().stream().map(e -> new Entreprise(e, secteurDao.findById(e.getSecteurId())) ).collect(Collectors.toList());
    }
    public Optional<Entreprise> getById(UUID id) {
        return entrepriseDao.findById(id).map(e -> new Entreprise(e, secteurDao.findById(e.getSecteurId())));
    }
    public Entreprise create(Entreprise e, Secteur s) {
        return new Entreprise(
            entrepriseDao.save( new EntrepriseEntity(e, s.getId()) ),
            s.getName()
        );
    }

}
