package com.devops.studylink.post;

import com.devops.studylink.post.controllers.dto.PostCreationDto;
import com.devops.studylink.post.controllers.dto.PostDto;
import com.devops.studylink.post.repositories.entity.PostEntity;
import com.devops.studylink.post.services.model.Post;
import com.devops.studylink.post.exception.PostException;

public class PostMapper {

    // Create model from dto
    public static Post createModelDto(PostCreationDto p) throws PostException { 
        return new Post(p.getContent());
    }
    // Create model from entity
    public static Post createModelEntity(PostEntity p) { 
        return new Post(p.getId(), p.getContent(), p.getCreationDate());
    }
    // Create dto from model
    public static PostDto createDto (Post p) { 
        return new PostDto(p.getId(), p.getContent(), p.getCreationDate());
    }
    // Create entity from model
    public static PostEntity createEntity(Post p) { 
        return new PostEntity(p.getContent(), p.getCreationDate());
    }
    
}
