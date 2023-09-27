package com.olvera.blog.payload;

import com.olvera.blog.entity.Post;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

    private Long postId;

    private String title;

    private String description;

    private String content;

}
