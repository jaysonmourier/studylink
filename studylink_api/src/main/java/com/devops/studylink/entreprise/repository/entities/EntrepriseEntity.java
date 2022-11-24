package com.devops.studylink.entreprise.repository.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.devops.studylink.entreprise.service.Entreprise;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Entreprise")
@Table(name="Entreprise")
@Getter @Setter @NoArgsConstructor 
public class EntrepriseEntity {

    public EntrepriseEntity(Entreprise e, UUID secteurId) {
        this.name = e.getName();
        this.secteurId = secteurId;
    }

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="secteur")
    private UUID secteurId;
}
