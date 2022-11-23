package com.devops.studylink.Salaire.dto;

import java.util.UUID;

import com.devops.studylink.Salaire.service.Salaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaireDto {

    private UUID id;
    UUID user;
    Double grossSalary;

    public SalaireDto(Salaire s) {
        this.id = s.getId();
        this.user = s.getUser();
        this.grossSalary = s.getGrossSalary();
    }

}
