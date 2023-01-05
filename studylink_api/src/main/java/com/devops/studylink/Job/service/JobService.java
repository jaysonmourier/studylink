package com.devops.studylink.Job.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.devops.studylink.Job.repository.JobRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;


@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository s) {
        this.jobRepository = s;
    }

    public List<Job> getAll() {
        return this.jobRepository.getAll();
    }

    public Job getJobById(UUID id){
        Optional<Job> result = jobRepository.getPostById(id);
        return result.get();
    }

    public Job createJob(Job job) {
        return jobRepository.createJob(job);
    }

    public void deteJob(UUID id) {
        jobRepository.deleteJob(id);
    }

    public Job updateJob(UUID id, Job update){
        Job job = this.getJobById(id);
        job.update(update);
        return jobRepository.updateJob(id, job);
    }
}
