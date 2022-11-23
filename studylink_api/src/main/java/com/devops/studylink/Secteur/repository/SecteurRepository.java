package com.devops.studylink.Secteur.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
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

}
