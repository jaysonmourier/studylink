package com.devops.studylink.post.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.devops.studylink.post.repositories.entities.PostEntity;
import com.devops.studylink.post.services.Post;

@Service
public class PostRepository {
    
    /**| INIT |**/
    
    private final PostDao postDao;
    PostRepository( PostDao p ) {
        this.postDao = p;
    }

    /**| METHODS |**/

    public List<Post> getPosts() {
        return postDao.findWithLimit(PageRequest.of(0, 10)).stream().map( p -> new Post(p) ).collect( Collectors.toList() );
    }

    public Optional<Post> getPostById(UUID id) {
        return postDao.findById(id).map( p -> new Post(p) );
    }

    public Post createPost(Post post) {
        return new Post(postDao.save(new PostEntity(post)));
    }

    public void deletePost(UUID id) {
        postDao.delete( postDao.findById(id).get() );
    }

    public Post updatePost(UUID id, Post post) {
        PostEntity save = new PostEntity(post); 
        save.setId(id);
        return new Post (postDao.save( save ) );
    }
    
}
