package com.devops.studylink.post.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.post.PostMapper;
import com.devops.studylink.post.domain.model.Post;
import com.devops.studylink.post.infra.dao.PostDao;
import com.devops.studylink.post.infra.entity.PostEntity;

@Service
public class PostRepository {
    
    /**| INIT |**/
    
    private final PostDao postDao;
    PostRepository( PostDao p ) {
        this.postDao = p;
    }

    /**| METHODS |**/

    public List<Post> getPosts() {
        return postDao.findAll().stream()
                .map( p -> PostMapper.createModelEntity(p) )
                .collect( Collectors.toList() );
    }

    public Optional<Post> getPostById(UUID id) {
        Optional<PostEntity> optionalPostEntity = postDao.findById(id);
        return optionalPostEntity.map( p -> PostMapper.createModelEntity(p) );
    }

    public Post createPost(Post post) {
        PostEntity response = postDao.save(PostMapper.createEntity(post));
        return PostMapper.createModelEntity(response);
    }

    public void deletePost(UUID id) {
        postDao.delete( postDao.findById(id).get() );
    }
    
}
