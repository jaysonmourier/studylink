package com.devops.studylink.post.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.devops.studylink.post.domain.model.Post;
import com.devops.studylink.post.infra.PostRepository;

@Service
public class PostService {

    /**| INIT |**/

    PostRepository postRepository;
    PostService( PostRepository p ) {
        this.postRepository = p;
    }

    /**| METHODS |**/

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public Optional<Post> getPostById(UUID id) {
        return postRepository.getPostById(id);
    }

    public Post createPost(Post post) {
        System.out.println("\033[0;31m" + "debug" + "\u001B[0m"); 
        return postRepository.createPost(post);
    }
    
}
