package com.devops.studylink.Salaire.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SalaireService {

    private final SalaireRepository salaireRepository;
    public SecteurService(SalaireRepository s) {
        this.salaireRepository = s;
    }
    
    public List<Salaire> getAll() {
        return this.salaireRepository.getAll();
    }
    
}
