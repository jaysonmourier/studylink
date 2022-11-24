package com.devops.studylink.Salaire.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.devops.studylink.Salaire.repository.SalaireRepository;
import com.devops.studylink.exceptions.PostException;
import com.devops.studylink.exceptions.PostNotFoundException;

@Service
public class SalaireService {

    private final SalaireRepository salaireRepository;

    public SalaireService(SalaireRepository s) {
        this.salaireRepository = s;
    }

    public List<Salaire> getAll() {
        return this.salaireRepository.getAll();
    }

    public Salaire getPostById(UUID id) throws PostException {
        Optional<Salaire> result = salaireRepository.getPostById(id);
        if (!result.isPresent())
            throw new PostNotFoundException();
        return result.get();
    }

    public Salaire createSalaire(Salaire salaire) throws HttpStatusCodeException {
        if((salaire.getUser() == null) || (salaire.getGrossSalary() == null)) throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
        return salaireRepository.createSalaire(salaire);
    }

}
