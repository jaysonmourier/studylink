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
        return postRepository.createPost(post);
    }

    public void detePost(UUID id) {
        postRepository.deletePost(id);
    }

    public void updatePost(UUID id, Post update) {
        Post post = getPostById(id).get();
        post.update(update);
        postRepository.updatePost(id, post);
    }
    
}
