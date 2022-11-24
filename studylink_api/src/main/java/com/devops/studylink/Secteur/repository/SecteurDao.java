package com.devops.studylink.Secteur.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.devops.studylink.Secteur.repository.entities.SecteurEntity;

@Repository
public interface SecteurDao extends JpaRepository<SecteurEntity, UUID> {

    @Query("select s from secteur s where s.name = :name")
    Optional<SecteurEntity> findByName(String name);
}
