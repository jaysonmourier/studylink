package com.devops.studylink.User.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserCreationDto {
    String name;
    String lastname;
    String email;
    Date dateNaissance;

}
