package com.devops.studylink.post.infra.entity;

import java.util.Date;
import javax.persistence.*;

@Entity(name="post")
@Table(name="post")
public class PostEntity {

    public PostEntity() {}
    public PostEntity(String content, Date creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="content")
    private String content;

    @Column(name="creationDate")
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
