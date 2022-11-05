package com.devops.studylink.post.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.studylink.post.api.dto.PostDto;
import com.devops.studylink.post.domain.PostService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController()
@RequestMapping("/posts")
public class PostController {
    
    private final PostService postService;
    PostController( PostService p ) {
        this.postService = p;
    }

    @GetMapping()
    public List<PostDto> getPosts() { return null ; }

    @GetMapping("/{uuid}")
    public ResponseEntity<PostDto> getPostById( @PathVariable UUID id ) { return null ; }

    @PostMapping()
    public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto ) { return null ; }
    
}
