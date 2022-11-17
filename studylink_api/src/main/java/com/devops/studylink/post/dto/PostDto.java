package com.devops.studylink.post.dto;

import java.util.Date;
import java.util.UUID;
import com.devops.studylink.post.services.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PostDto {

    public PostDto(Post p) {
        this.id = p.getId();
        this.content = p.getContent();
        this.creationDate = p.getCreationDate();
    }

    private UUID id;
    private String content;
    private Date creationDate;

}
