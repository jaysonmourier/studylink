package com.devops.studylink.Job.repository.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.devops.studylink.Job.service.Job;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "job")
@Entity(name = "job")
public class JobEntity {

    public JobEntity(Job job) {
        this.id = job.getId();
        this.user = job.getUser();
        this.name = job.getName();
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

    @Column(name = "name")
    private String name;
}
