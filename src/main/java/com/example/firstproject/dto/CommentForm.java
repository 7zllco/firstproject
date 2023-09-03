package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CommentForm {
    private Long id;
    private Long article_id;
    private String nickname;
    private String body;
}
