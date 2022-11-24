package com.devops.studylink.Job.service;

import java.util.UUID;

import com.devops.studylink.Job.dto.JobCreationDto;
import com.devops.studylink.Job.repository.entities.JobEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    private UUID id;
    private UUID user;
    private String name;

    public Job(JobEntity j) {
        this.id = j.getId();
        this.user = j.getUser();
        this.name = j.getName();
    }

    public Job(JobCreationDto p){
        this.user = p.getUser();
        this.name = p.getName();
    }
    
}
