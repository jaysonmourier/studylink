package com.devops.studylink.Salaire.repository.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.devops.studylink.Salaire.service.Salaire;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "salaire")
@Entity(name = "salaire")
public class SalaireEntity {

    public SalaireEntity(Salaire salaire) {
        this.id = salaire.getId();
        this.user = salaire.getUser();
        this.grossSalary = salaire.getGrossSalary();
    }

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Type(type = "uuid-char")
    @Column(name = "user")
    private UUID user;

    @Column(name = "grossSalary")
    private Double grossSalary;
}
