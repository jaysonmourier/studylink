package com.devops.studylink.Salaire.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.studylink.Salaire.repository.entities.SalaireEntity;

@Repository
public interface SalaireDao extends JpaRepository<SalaireEntity, UUID> {
}
