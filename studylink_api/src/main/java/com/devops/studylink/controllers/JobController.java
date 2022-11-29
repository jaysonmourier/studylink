package com.devops.studylink.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.devops.studylink.Job.dto.JobCreationDto;
import com.devops.studylink.Job.dto.JobDto;
import com.devops.studylink.Job.service.Job;
import com.devops.studylink.Job.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
    
    private final JobService jobService;
    public JobController(JobService s) {
        this.jobService = s;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<JobDto> getAll() {
        return this.jobService.getAll().stream().map(s -> new JobDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<JobDto> getJobById( @PathVariable("uuid") String id ) {
        
        return ResponseEntity.ok(new JobDto(jobService.getJobById(UUID.fromString(id))));
    }
    
    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<JobDto> createJob(@RequestBody JobCreationDto jobDto ) {
        
        return new ResponseEntity<JobDto> (
                new JobDto( jobService.createJob( new Job(jobDto) ) ), HttpStatus.CREATED
            );
    }

    @DeleteMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity deleteJob(@PathVariable("uuid") String id) {
        
        jobService.deteJob( UUID.fromString(id) );
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity updateJob(@PathVariable("uuid") String id, @RequestBody JobCreationDto jobDto ) {
        return ResponseEntity.ok(
            new JobDto( jobService.updateJob(UUID.fromString(id), new Job(jobDto)) )
        );
    }

}
