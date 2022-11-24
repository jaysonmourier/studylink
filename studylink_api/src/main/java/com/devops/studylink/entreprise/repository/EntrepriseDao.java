package com.devops.studylink.entreprise.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devops.studylink.entreprise.repository.entities.EntrepriseEntity;

@Repository
public interface EntrepriseDao extends JpaRepository<EntrepriseEntity, UUID>  {
}
