package com.devops.studylink.User.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devops.studylink.User.repository.entities.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, UUID> {
}
