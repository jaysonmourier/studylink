package com.devops.studylink.post.repositories.entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.devops.studylink.post.services.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="post") @Table(name="post")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class PostEntity {

    public PostEntity(Post p) {
        this.content = p.getContent();
        this.creationDate = p.getCreationDate();
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
