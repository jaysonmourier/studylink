package com.devops.studylink.controllers;

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
import com.devops.studylink.exceptions.PostException;
import com.devops.studylink.exceptions.PostNotFoundException;
import com.devops.studylink.post.dto.PostCreationDto;
import com.devops.studylink.post.dto.PostDto;
import com.devops.studylink.post.services.Post;
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
        return postService.getPosts().stream().map(p -> new PostDto(p)).collect(Collectors.toList()); 
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{uuid}")
    public ResponseEntity getPostById( @PathVariable("uuid") String id ) { 
        try { 
            return ResponseEntity.ok( new PostDto( postService.getPostById( UUID.fromString(id) ) ) );
        } 
        catch(PostNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(PostException e) { return ResponseEntity.badRequest().body(e.getMessage()); }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping()
    public ResponseEntity createPost( @RequestBody PostCreationDto postDto ) {
        try {
            return new ResponseEntity<PostDto> (
                new PostDto( postService.createPost( new Post(postDto) ) ), HttpStatus.CREATED
            );
        }
        catch( PostException e ) { return ResponseEntity.badRequest().body(e.getMessage()); }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deletePost(@PathVariable("uuid") String id) {
        try {
            postService.detePost( UUID.fromString(id) );
            return ResponseEntity.ok().build();
        }
        catch(PostNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(PostException e) { return ResponseEntity.badRequest().body(e.getMessage()); }
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity updatePost( @PathVariable("uuid") String id, @RequestBody PostCreationDto postDto ) {
        try {
            return ResponseEntity.ok(
                new PostDto( postService.updatePost(UUID.fromString(id), new Post(postDto)) )
            );
        }
        catch(PostNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(PostException e) { return ResponseEntity.badRequest().body(e.getMessage()); }
    }

}
