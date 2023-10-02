package com.olvera.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
public class PostDto {
    private Long postId;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
