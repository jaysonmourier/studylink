package com.devops.studylink.post.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.devops.studylink.exceptions.PostException;
import com.devops.studylink.exceptions.PostNotFoundException;
import com.devops.studylink.post.repositories.PostRepository;

@Service
public class PostService {

    /**| INIT |**/

    PostRepository postRepository;
    PostService( PostRepository p ) {
        this.postRepository = p;
    }

    /**| POSTS |**/

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public Post getPostById(UUID id) throws PostException {
        Optional<Post> result = postRepository.getPostById(id);
        if ( ! result.isPresent() ) throw new PostNotFoundException();
        return result.get();
    }

    public Post createPost(Post post) throws PostException {
        return postRepository.createPost(post);
    }

    public void detePost(UUID id) throws PostException {
        if ( ! postRepository.getPostById(id).isPresent() ) throw new PostNotFoundException();
        postRepository.deletePost(id);
    }

    public Post updatePost(UUID id, Post update) throws PostException {
        Post post = this.getPostById(id);
        post.update(update);
        return postRepository.updatePost(id, post);
    }

    /**| LIKES |**/

    public void likePost(UUID id) throws PostException {
        Post post = getPostById(id);
    }
    
}
