package com.devops.studylink.post.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.post.PostMapper;
import com.devops.studylink.post.api.dto.PostDto;
import com.devops.studylink.post.domain.PostService;

@RestController()
@RequestMapping("/posts")
public class PostController {
    
    /**| INIT |**/

    private final PostService postService;
    PostController( PostService p ) {
        this.postService = p;
    }

    /**| ENDPOINTS |**/

    @GetMapping()
    public List<PostDto> getPosts() { 
        return postService.getPosts().stream().map(p -> PostMapper.createDto(p))
                .collect(Collectors.toList()); 
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<PostDto> getPostById( @PathVariable("uuid") UUID id ) { 
        return postService.getPostById(id)
            .map(p -> PostMapper.createDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public PostDto createPost( @RequestBody PostDto postDto ) {
        return PostMapper.createDto( postService.createPost( PostMapper.createModelDto(postDto) ) );
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity deletePost(@PathVariable("uuid") UUID id) {
        
        if (! postService.getPostById(id).isPresent() ) return ResponseEntity.notFound().build();
        
        postService.detePost(id);
        return ResponseEntity.ok().build();
    }

}
