package com.devops.studylink.Salaire.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class SalaireService {

    /**| INIT |**/

    SalaireRepository SalaireRepository;
    SalaireService( SalaireRepository p ) {
        this.SalaireRepository = p;
    }

    /**| SalaireS |**/

    public List<Salaire> getSalaires() {
        return SalaireRepository.getSalaires();
    }

    public Salaire getSalaireById(UUID id) throws SalaireException {
        Optional<Salaire> result = SalaireRepository.getSalaireById(id);
        if ( ! result.isPresent() ) throw new SalaireNotFoundException();
        return result.get();
    }

    public Salaire createSalaire(Salaire Salaire) throws SalaireException {
        return SalaireRepository.createSalaire(Salaire);
    }

    public void deteSalaire(UUID id) throws SalaireException {
        if ( ! SalaireRepository.getSalaireById(id).isPresent() ) throw new SalaireNotFoundException();
        SalaireRepository.deleteSalaire(id);
    }

    public Salaire updateSalaire(UUID id, Salaire update) throws SalaireException {
        Salaire Salaire = this.getSalaireById(id);
        Salaire.update(update);
        return SalaireRepository.updateSalaire(id, Salaire);
    }

    /**| LIKES |**/

    public void likeSalaire(UUID id) throws SalaireException {
        Salaire Salaire = getSalaireById(id);
    }
    
}
