package com.devops.studylink.Secteur.repository.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.devops.studylink.Secteur.service.Secteur;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="secteur")
@Table(name="secteur")
@Getter @Setter @NoArgsConstructor
public class SecteurEntity {

    public SecteurEntity(Secteur s) {
        this.name = s.getName();
    }

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;
    

}
