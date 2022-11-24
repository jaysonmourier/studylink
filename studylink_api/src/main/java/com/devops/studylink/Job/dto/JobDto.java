package com.devops.studylink.Job.dto;

import java.util.UUID;

import com.devops.studylink.Job.service.Job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {

    private UUID id;
    private UUID user;
    private String name;

    public JobDto(Job j) {
        this.id = j.getId();
        this.user = j.getUser();
        this.name = j.getName();
    }

}