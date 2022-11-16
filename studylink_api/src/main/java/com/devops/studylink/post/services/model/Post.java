package com.devops.studylink.post.services.model;

import java.util.Date;
import java.util.UUID;

public class Post {

    public Post() {}
    public Post(UUID id, String content, Date creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = new Date();
    }

    private UUID id;
    private String content;
    private Date creationDate;

    /**| DOMAIN METHODS |**/

    public void update(Post update) {
        setContent(update.getContent());
        // setCreationDate(update.getCreationDate()); // ?
    }

    /**| SETTERS & GETTERS |**/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}
