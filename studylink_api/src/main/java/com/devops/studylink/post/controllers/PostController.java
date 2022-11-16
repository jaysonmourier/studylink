package com.devops.studylink.post.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.post.PostMapper;
import com.devops.studylink.post.controllers.dto.PostCreationDto;
import com.devops.studylink.post.controllers.dto.PostDto;
import com.devops.studylink.post.services.PostService;
import com.devops.studylink.post.services.PostService;

@RestController()
@RequestMapping("/posts")
public class PostController {
    
    /**| INIT |**/

    private final PostService postService;
    PostController( PostService p ) {
        this.postService = p;
    }

    /**| ENDPOINTS |**/

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping()
    public List<PostDto> getPosts() { 
        return postService.getPosts().stream().map(p -> PostMapper.createDto(p))
                .collect(Collectors.toList()); 
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{uuid}")
    public ResponseEntity<PostDto> getPostById( @PathVariable("uuid") UUID id ) { 
        return postService.getPostById(id)
            .map(p -> PostMapper.createDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping()
    public ResponseEntity<PostDto> createPost( @RequestBody PostDto postDto ) {
        return new ResponseEntity<PostDto> (
            PostMapper.createDto( postService.createPost( PostMapper.createModelDto(postDto) ) ),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deletePost(@PathVariable("uuid") UUID id) {
        
        if (! postService.getPostById(id).isPresent() ) return ResponseEntity.notFound().build();
        
        postService.detePost(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity updatePost( @PathVariable("uuid") UUID id, @RequestBody PostDto postDto ) {

        if (! postService.getPostById(id).isPresent() ) return ResponseEntity.notFound().build();

        postService.updatePost(id, PostMapper.createModelDto(postDto));
        return null;

    }

}
