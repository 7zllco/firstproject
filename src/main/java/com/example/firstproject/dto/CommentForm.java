package com.example.firstproject.dto;

import com.example.firstproject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentForm {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentForm createCommentDto(Comment comment) {
        return new CommentForm(comment.getId(), comment.getArticle().getId(), comment.getNickname(), comment.getBody());
    }

}
