package com.devops.studylink.post.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.devops.studylink.post.exception.PostException;
import com.devops.studylink.post.repositories.PostRepository;
import com.devops.studylink.post.services.model.Post;

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

    public Post createPost(Post post) throws PostException {
        return postRepository.createPost(post);
    }

    public void detePost(UUID id) {
        postRepository.deletePost(id);
    }

    public Post updatePost(UUID id, Post update) throws PostException {
        Post post = getPostById(id).get();
        post.update( update );
        return postRepository.updatePost(id, post);
    }
    
}
