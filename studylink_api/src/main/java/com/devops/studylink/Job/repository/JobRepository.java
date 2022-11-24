package com.devops.studylink.Job.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.devops.studylink.Job.repository.entities.JobEntity;
import com.devops.studylink.Job.service.Job;

import org.springframework.stereotype.Service;


@Service
public class JobRepository {

    private final JobDao jobDao;

    public JobRepository(JobDao j) {
        this.jobDao = j;
    }

    public List<Job> getAll() {
        return jobDao.findAll().stream().map(j -> new Job(j)).collect(Collectors.toList());
    }

    public Optional<Job> getPostById(UUID id) {
        return jobDao.findById(id).map(p -> new Job(p));
    }

    public Job createJob(Job u) {
        return new Job(jobDao.save(new JobEntity(u)));
    }

    public void deleteJob(UUID id) {
        jobDao.delete( jobDao.findById(id).get() );
    }

    public Job updateJob(UUID id, Job job) {
        JobEntity save = new JobEntity(job); 
        save.setId(id);
        return new Job (jobDao.save( save ) );
    }

}