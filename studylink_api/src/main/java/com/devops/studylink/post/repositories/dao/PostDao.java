package com.devops.studylink.post.repositories.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.studylink.post.repositories.entity.PostEntity;

@Repository
public interface PostDao extends JpaRepository<PostEntity, UUID> {
}
