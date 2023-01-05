package com.devops.studylink.User.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @NoArgsConstructor @AllArgsConstructor
public class UserCreationDto {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private String dateNaissance;

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() throws Exception {
        System.out.println("****DATE :: "+dateNaissance);
        return new SimpleDateFormat("yyyy/MM/dd").parse(this.dateNaissance);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
