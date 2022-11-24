package com.devops.studylink.Salaire.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SalaireCreationDto {
    UUID user;
    Double grossSalary;
}
