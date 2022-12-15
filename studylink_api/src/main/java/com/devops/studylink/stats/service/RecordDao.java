package com.devops.studylink.stats.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devops.studylink.stats.repository.entities.RecordEntity;

@Repository
public interface RecordDao extends JpaRepository<RecordEntity, Long> {
}
