package com.devops.studylink.Salaire.service;

import java.util.UUID;

import com.devops.studylink.Salaire.dto.SalaireCreationDto;
import com.devops.studylink.Salaire.repository.entities.SalaireEntity;
import com.devops.studylink.exceptions.PostException;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salaire {

    private UUID id;
    private UUID user;
    private Double grossSalary;

    public Salaire(SalaireEntity e) {
        this.id = e.getId();
        this.user = e.getUser();
        this.grossSalary = e.getGrossSalary();
    }

    public Salaire(SalaireCreationDto p) throws PostException {
        this.user = p.getUser();
        this.grossSalary = p.getGrossSalary();
    }
}
