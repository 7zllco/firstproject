package com.example.firstproject.api;

import com.example.firstproject.dto.CommentForm;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;


    // 조회
    @GetMapping("/articles/{articleId}/comments")
    public List<Comment> index(@PathVariable Long articleId) {
        return commentService.index(articleId);
    }

    // 생성
    @PostMapping("/articles/{articleId}/comments")
    public Comment create(@PathVariable Long articleId, @RequestBody CommentForm dto) {
        return commentService.create(articleId, dto);
    }

    // 수정
    @PatchMapping("/comments/{id}")
    public Comment update(@PathVariable Long id) {
        return commentService.update(id);
    }

    // 삭제
    @DeleteMapping("/comments/{id}")
    public Comment delete(@PathVariable Long id) {
        return commentService.delete(id);
    }

}
