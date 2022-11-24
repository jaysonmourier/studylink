package com.devops.studylink.entreprise.dto;

import java.util.UUID;

import com.devops.studylink.entreprise.service.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EntrepriseDto {

    public EntrepriseDto(Entreprise e) {
        this.id = e.getId();
        this.name = e.getName();
        this.secteur = e.getSecteur();
    }

    private UUID id;
    private String name;
    private String secteur;
}
