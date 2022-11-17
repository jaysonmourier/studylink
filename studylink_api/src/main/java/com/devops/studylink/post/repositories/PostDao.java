package com.devops.studylink.post.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.devops.studylink.post.repositories.entities.PostEntity;

@Repository
public interface PostDao extends JpaRepository<PostEntity, UUID> {
    @Query("select p from post p order by p.creationDate desc")
    List<PostEntity> findWithLimit(PageRequest pageRequest);
}
