package com.devops.studylink.Secteur.service;

import java.text.Normalizer;
import java.util.UUID;
import com.devops.studylink.Secteur.dto.SecteurCreationDto;
import com.devops.studylink.Secteur.repository.entities.SecteurEntity;
import com.devops.studylink.exceptions.BadResourceException;
import com.devops.studylink.exceptions.StudyLinkApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Secteur {

    /** INIT **/

    private UUID id;
    private String name;
    
    public Secteur(SecteurCreationDto s) throws StudyLinkApiException { 
        this.setNameFormatted(s.getName());
    }
    public Secteur(SecteurEntity s) {
        this.id = s.getId();
        this.name = s.getName();
    }

    /** LOGIC **/

    private void setNameFormatted(String name) throws StudyLinkApiException {
        if (name == null) throw new BadResourceException();
        this.name = Normalizer.normalize( name.trim().toUpperCase(), Normalizer.Form.NFD ).replaceAll("[^\\p{ASCII}]", "").replaceAll("(\s+|-)", "_");    
    }

}
