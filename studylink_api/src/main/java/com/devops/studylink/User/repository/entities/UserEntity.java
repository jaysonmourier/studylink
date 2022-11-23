package com.devops.studylink.User.repository.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devops.studylink.User.service.User;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="user")
@Getter @Setter @NoArgsConstructor
public class UserEntity {

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="dateNaissance")
    private Date dateNaissance;

    @Column(name="dateCreation")
    private Date dateCreation;
    
    public UserEntity(User u) {
        this.name = u.getName();
        this.lastname = u.getLastname();
        this.dateNaissance = u.getDateNaissance();
    }

}
