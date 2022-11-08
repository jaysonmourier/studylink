package com.devops.studylink.post.domain.model;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Post {

    private UUID id;
    private String content;
    private Date creationDate;

    /**| DOMAIN METHODS |**/

    public void update(Post update) {
        setContent(update.getContent());
        // setCreationDate(update.getCreationDate()); // ?
    }

    // TODO : public void create(Post)

}
