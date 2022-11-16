package com.devops.studylink.post.repositories.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="post")
@Table(name="post")
public class PostEntity {

    public PostEntity() {}
    public PostEntity(String content, Date creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }

    @Id
    @Type(type="uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private UUID id;

    @Column(name="content")
    private String content;

    @Column(name="creationDate")
    private Date creationDate;

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
