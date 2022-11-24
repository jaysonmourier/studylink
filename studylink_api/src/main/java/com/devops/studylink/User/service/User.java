package com.devops.studylink.User.service;

import java.util.UUID;
import java.util.Date;

import com.devops.studylink.User.dto.UserCreationDto;
import com.devops.studylink.User.repository.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private Date dateNaissance;
    private Date dateCreation;

    public User(UserEntity e) {
        this.id = e.getId();
        this.name = e.getName();
        this.lastname = e.getLastname();
        this.email = e.getEmail();
        this.dateNaissance = e.getDateNaissance();
        this.dateCreation = e.getDateCreation();
    }

    public User(UserCreationDto u){
        setName(u.getName());
        setLastName(u.getLastname());
        setEmail(u.getEmail());
        setDateNaissance(u.getDateNaissance());
        this.dateCreation = new Date();
    }

    public void update(User update){
        setName(update.getName());
        setLastName(update.getLastname());
        setEmail(update.getEmail());
        setDateNaissance(update.getDateNaissance());

    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDateNaissance(Date dateNaissance){
        this.dateNaissance = dateNaissance;
    }

}
