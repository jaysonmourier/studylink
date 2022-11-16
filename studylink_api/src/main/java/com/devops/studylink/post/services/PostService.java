package com.devops.studylink.post.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
<<<<<<< HEAD:studylink_api/src/main/java/com/devops/studylink/post/services/PostService.java

import com.devops.studylink.post.repositories.PostRepository;
import com.devops.studylink.post.services.model.Post;
=======
import com.devops.studylink.post.domain.model.Post;
import com.devops.studylink.post.exception.PostException;
import com.devops.studylink.post.infra.PostRepository;
>>>>>>> post_crud_api:studylink_api/src/main/java/com/devops/studylink/post/domain/PostService.java

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
