package com.devops.studylink.post.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.devops.studylink.config.Converter;
import com.devops.studylink.post.domain.model.Post;
import com.devops.studylink.post.infra.dao.PostDao;
import com.devops.studylink.post.infra.entity.PostEntity;

@Service
public class PostRepository {
    private final PostDao postDao;
    PostRepository( PostDao p ) {
        this.postDao = p;
    }

    public List<Post> getPosts() {
        return postDao.findAll().stream()
                .map( p -> new Converter().map(p, Post.class) )
                .collect( Collectors.toList() );
    }

    public Optional<Post> getPostById(UUID id) {
        Optional<PostEntity> optionalPostEntity = postDao.findById(id);
        return optionalPostEntity.map( p -> new Converter().map(p, Post.class) );
    }
}
