package com.crudo.controller;
import com.crudo.dto.PostDto;
import com.crudo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public List<PostDto> getAllPosts(){
       return postService.getAllPosts();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id){
        PostDto dto = postService.updatePost(postDto, id);
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity   ("Post is delete",HttpStatus.OK);
    }
}
