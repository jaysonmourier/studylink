package com.devops.studylink.post.domain.model;

import java.util.Date;

public class Post {

    public Post() {}
    public Post(Long id, String content, Date creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
    }

    private Long id;
    private String content;
    private Date creationDate;

    /**| SETTERS & GETTERS |**/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
