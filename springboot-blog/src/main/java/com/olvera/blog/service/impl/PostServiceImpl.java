package com.olvera.blog.service.impl;

import com.olvera.blog.entity.Post;
import com.olvera.blog.payload.PostDto;
import com.olvera.blog.repository.PostRepository;
import com.olvera.blog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert DTO to entity
        Post postCreated = Post.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .content(postDto.getContent())
                .build();

        postCreated = postRepository.save(postCreated);

        return PostDto.createDto(postCreated);
    }
}
