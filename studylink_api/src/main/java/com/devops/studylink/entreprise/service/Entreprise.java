package com.devops.studylink.entreprise.service;

import java.util.Optional;
import java.util.UUID;

import com.devops.studylink.Secteur.repository.entities.SecteurEntity;
import com.devops.studylink.entreprise.dto.EntrepriseDto;
import com.devops.studylink.entreprise.repository.entities.EntrepriseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Entreprise {

    public Entreprise(EntrepriseEntity e, String s) {
        this.id = e.getId();
        this.name = e.getName();
        this.secteur = s;
    }
    public Entreprise(EntrepriseEntity e, Optional<SecteurEntity> s) {
        this.id = e.getId();
        this.name = e.getName();
        if(s.isPresent()) this.secteur = this.secteur = s.get().getName();
    }
    public Entreprise(EntrepriseDto e) {
        this.name = e.getName();
        this.secteur = e.getSecteur();
    }

    private UUID id;
    private String name;
    private String secteur;

}
