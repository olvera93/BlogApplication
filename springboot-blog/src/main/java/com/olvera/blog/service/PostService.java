package com.olvera.blog.service;

import com.olvera.blog.payload.PostDto;
import com.olvera.blog.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Long postId);
    PostDto updatePost(Long postId, PostDto postDto);
    void deletePostById(Long postId);
}
