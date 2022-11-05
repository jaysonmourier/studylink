package com.devops.studylink.post.domain;

import org.springframework.stereotype.Service;
import com.devops.studylink.post.infra.PostRepository;

@Service
public class PostService {

    PostRepository postRepository;
    PostService( PostRepository p ) {
        this.postRepository = p;
    }
    
}
