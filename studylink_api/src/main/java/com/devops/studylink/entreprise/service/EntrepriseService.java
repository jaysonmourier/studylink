package com.devops.studylink.entreprise.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.devops.studylink.StudylinkApplication;
import com.devops.studylink.Secteur.repository.SecteurRepository;
import com.devops.studylink.Secteur.service.Secteur;
import com.devops.studylink.entreprise.repository.EntrepriseRepository;
import com.devops.studylink.exceptions.ResourceNotFoundException;
import com.devops.studylink.exceptions.StudyLinkApiException;
import java.util.Optional;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;
    private final SecteurRepository secteurRepository;
    public EntrepriseService(EntrepriseRepository e, SecteurRepository s) {
        this.entrepriseRepository = e;
        this.secteurRepository = s;
    }
    
    public List<Entreprise> getAll() {
        return entrepriseRepository.getAll();
    }

    public Entreprise getById(UUID id) throws StudyLinkApiException {
        Optional<Entreprise> e = entrepriseRepository.getById(id);
        if(! e.isPresent()) throw new ResourceNotFoundException();
        return e.get();
    }

    public Entreprise create(Entreprise e) throws StudyLinkApiException {
        Optional<Secteur> s = secteurRepository.getByName(e.getSecteur());
        if (! s.isPresent()) throw new ResourceNotFoundException();
        return entrepriseRepository.create(e, s.get());
    }
}
