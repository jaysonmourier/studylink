package com.devops.studylink.post.services.model;

import java.util.Date;
import java.util.UUID;
import com.devops.studylink.post.exception.PostContentException;
import com.devops.studylink.post.exception.PostException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Post {

    public Post( String content ) throws PostException {
        setContent( content );
        this.creationDate = new Date();
    }

    private UUID id;
    private String content;
    private Date creationDate;

    /**| DOMAIN METHODS |**/

    public void setContent(String content) throws PostContentException {
        if ( content == null || content.trim().isEmpty() ) throw new PostContentException();
        this.content = content.trim();
    }

    // TODO : Ajouter lastUpdateDate
    public void update(Post update) throws PostException {
        setContent(update.getContent());
    }

}
