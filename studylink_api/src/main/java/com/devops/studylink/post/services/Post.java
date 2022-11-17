package com.devops.studylink.post.services;

import java.util.Date;
import java.util.UUID;
import com.devops.studylink.exceptions.PostContentException;
import com.devops.studylink.exceptions.PostException;
import com.devops.studylink.post.dto.PostCreationDto;
import com.devops.studylink.post.repositories.entities.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Post {

    public Post(PostEntity p) {
        this.id = p.getId();
        this.content = p.getContent();
        this.creationDate = p.getCreationDate();
    }
    public Post (PostCreationDto p) throws PostException {
        setContent(p.getContent());
        this.creationDate = new Date();
    }

    private UUID id;
    private String content;
    private Date creationDate;

    /**| DOMAIN METHODS |**/

    public void update(Post update) throws PostException {
        setContent(update.getContent());
    }
    
    public void setContent(String content) throws PostException {
        if (content == null || content.trim().isEmpty()) throw new PostContentException();
        this.content = content;
    }
    
}
