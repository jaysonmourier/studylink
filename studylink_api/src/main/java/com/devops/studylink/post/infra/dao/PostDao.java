package com.devops.studylink.post.infra.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devops.studylink.post.infra.entity.PostEntity;

@Repository
public interface PostDao extends JpaRepository<PostEntity, Long> {
}
