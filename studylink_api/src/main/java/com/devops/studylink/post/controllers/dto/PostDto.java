package com.devops.studylink.post.controllers.dto;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PostDto {

    private UUID id;
    private String content;
    private Date creationDate;

}
