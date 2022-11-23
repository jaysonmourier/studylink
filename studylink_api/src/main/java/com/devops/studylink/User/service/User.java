package com.devops.studylink.User.service;

import java.sql.Date;
import java.util.UUID;

import com.devops.studylink.Secteur.repository.entities.SecteurEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

    private UUID id;
    private String forname;
    private String name;
    private Date dateNaissance;
    private Date dateCreation;

    public User(UserEntity e) {
        this.id = e.getId();
        this.forname = e.getForname();
        this.name = e.getName();
        this.dateNaissance = e.getDateNaissance();
        this.dateCreation = e.getDateCreation();
    }

}
