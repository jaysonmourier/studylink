package com.devops.studylink.Secteur.service;

import java.util.UUID;

import com.devops.studylink.Secteur.repository.entities.SecteurEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Secteur {

    private UUID id;
    private String name;

    public Secteur(SecteurEntity e) {
        this.id = e.getId();
        this.name = e.getName();
    }

}
