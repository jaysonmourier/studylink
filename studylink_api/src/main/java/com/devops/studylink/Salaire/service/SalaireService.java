package com.devops.studylink.Salaire.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.devops.studylink.Salaire.repository.SalaireRepository;

@Service
public class SalaireService {

    private final SalaireRepository salaireRepository;

    public SalaireService(SalaireRepository s) {
        this.salaireRepository = s;
    }

    public List<Salaire> getAll() {
        return this.salaireRepository.getAll();
    }

}
