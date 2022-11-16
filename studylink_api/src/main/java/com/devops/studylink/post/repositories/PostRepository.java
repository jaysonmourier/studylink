package com.devops.studylink.post.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.post.PostMapper;
import com.devops.studylink.post.repositories.dao.PostDao;
import com.devops.studylink.post.repositories.entity.PostEntity;
import com.devops.studylink.post.services.model.Post;

@Service
public class PostRepository {
    
    /**| INIT |**/
    
    private final PostDao postDao;
    PostRepository( PostDao p ) {
        this.postDao = p;
    }

    /**| METHODS |**/

    public List<Post> getPosts() {
        return postDao.findAll().stream().map( p -> PostMapper.createModelEntity(p) ).collect( Collectors.toList() );
    }

    public Optional<Post> getPostById(UUID id) {
        return postDao.findById(id).map( p -> PostMapper.createModelEntity(p) );
    }

    public Post createPost(Post post) {
        return PostMapper.createModelEntity(postDao.save(PostMapper.createEntity(post)));
    }

    public void deletePost(UUID id) {
        postDao.delete( postDao.findById(id).get() );
    }

    public Post updatePost(UUID id, Post post) {
        PostEntity save = PostMapper.createEntity(post); 
        save.setId(id);
        return PostMapper.createModelEntity( postDao.save( save ) );
    }
    
}
