package com.devops.studylink.User.dto;

import java.util.Date;
import java.util.UUID;

import com.devops.studylink.User.repository.entities.UserEntity;
import com.devops.studylink.User.service.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto {
    
    private UUID id;
    private String name;
    private String lastname;
    private Date dateNaissance;
    private Date dateCreation;

    public UserDto(User e) {
        this.id = e.getId();
        this.name = e.getName();
        this.lastname = e.getLastname();
        this.dateNaissance = e.getDateNaissance();
        this.dateCreation = e.getDateCreation();
    }
    
}
