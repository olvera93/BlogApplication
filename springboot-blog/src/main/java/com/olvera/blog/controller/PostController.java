package com.olvera.blog.controller;

import com.olvera.blog.payload.PostDto;
import com.olvera.blog.payload.PostResponse;
import com.olvera.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.olvera.blog.utils.AppConstants.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createdPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public PostResponse getAllPost(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    // get post by id
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "postId") Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    // update post by id rest api
    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "postId") Long postId, @RequestBody PostDto postDto) {
        PostDto postResponse = postService.updatePost(postId, postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "postId") Long postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
