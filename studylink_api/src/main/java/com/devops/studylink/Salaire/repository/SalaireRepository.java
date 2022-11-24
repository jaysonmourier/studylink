package com.devops.studylink.Salaire.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.devops.studylink.Salaire.repository.entities.SalaireEntity;
import com.devops.studylink.Salaire.service.Salaire;

@Service
public class SalaireRepository {

    private final SalaireDao salaireDao;

    public SalaireRepository(SalaireDao s) {
        this.salaireDao = s;
    }

    public List<Salaire> getAll() {
        return salaireDao.findAll().stream().map(s -> new Salaire(s)).collect(Collectors.toList());
    }

    public Optional<Salaire> getPostById(UUID id) {
        return salaireDao.findById(id).map( p -> new Salaire(p) );
    }

    public Salaire createPost(Salaire salaire) {
        return new Salaire(salaireDao.save(new SalaireEntity(salaire)));
    }

}
