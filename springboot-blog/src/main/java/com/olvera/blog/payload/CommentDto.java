package com.olvera.blog.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CommentDto {

    private Long commentId;

    private String name;

    private String email;

    private String body;

}
