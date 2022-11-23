package com.devops.studylink.Secteur.service;

import com.devops.studylink.Secteur.repository.SecteurRepository;
import com.devops.studylink.exceptions.DuplicateResourceException;
import com.devops.studylink.exceptions.ResourceNotFoundException;
import com.devops.studylink.exceptions.StudyLinkApiException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public Secteur getById(UUID id) throws StudyLinkApiException {
        Optional<Secteur> secteur = this.secteurRepository.geyById(id);
        if (! secteur.isPresent()) throw new ResourceNotFoundException();
        return secteur.get();
    }

    public Secteur createSecteur(Secteur secteur) throws StudyLinkApiException {

        // Ne pas enregistrer des doublons (noms identiques) 
        Set<String> secteurNamesList = getAll().stream().map(s -> s.getName()).collect(Collectors.toSet());
        if ( secteurNamesList.contains( secteur.getName() ) ) throw new DuplicateResourceException();
        
        return secteurRepository.createSecteur(secteur);

    }

    public void delete(UUID id) throws StudyLinkApiException {
        Optional<Secteur> secteur = this.secteurRepository.geyById(id);
        if (! secteur.isPresent()) throw new ResourceNotFoundException();
        secteurRepository.delete(secteur.get());
    }
    
}
