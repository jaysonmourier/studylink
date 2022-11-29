package com.devops.studylink.Job.repository;

import java.util.UUID;

import com.devops.studylink.Job.repository.entities.JobEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobDao extends JpaRepository<JobEntity, UUID> {
}
