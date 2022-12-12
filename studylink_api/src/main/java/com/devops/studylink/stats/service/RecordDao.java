package com.devops.studylink.stats.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devops.studylink.stats.repository.entities.RecordEntity;

public interface RecordDao extends JpaRepository<RecordEntity, Long> {
}
