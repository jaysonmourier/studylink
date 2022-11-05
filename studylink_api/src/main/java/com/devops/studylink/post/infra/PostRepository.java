package com.devops.studylink.post.infra;

import org.springframework.stereotype.Service;

import com.devops.studylink.post.infra.dao.PostDao;

@Service
public class PostRepository {
    private final PostDao postDao;
    PostRepository( PostDao p ) {
        this.postDao = p;
    }
}
