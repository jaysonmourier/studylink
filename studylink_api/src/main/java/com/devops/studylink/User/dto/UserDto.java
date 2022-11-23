package com.devops.studylink.User.dto;

import java.sql.Date;
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
    private String forname;
    private String name;
    private Date dateNaissance;
    private Date dateCreation;

    public UserDto(UserEntity e) {
        this.id = e.getId();
        this.forname = e.getForname();
        this.name = e.getName();
        this.dateNaissance = e.getDateNaissance();
        this.dateCreation = e.getDateCreation();
    }
    
}
