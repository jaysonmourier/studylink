package com.devops.studylink.post.infra.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="post")
@Table(name="post")
@Getter @Setter @NoArgsConstructor
public class PostEntity {

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

}
