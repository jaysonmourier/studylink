package com.devops.studylink.Secteur.service;

import com.devops.studylink.Secteur.repository.SecteurRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SecteurService {

    private final SecteurRepository secteurRepository;
    public SecteurService(SecteurRepository s) {
        this.secteurRepository = s;
    }
    
    public List<Secteur> getAll() {
        return this.secteurRepository.getAll();
    }
    
}
