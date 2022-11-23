package com.devops.studylink.Secteur.dto;

import java.util.UUID;
import com.devops.studylink.Secteur.service.Secteur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SecteurDto {
    
    private UUID id;
    String name;

    public SecteurDto(Secteur s) {
        this.id = s.getId();
        this.name = s.getName();
    }
    
}
