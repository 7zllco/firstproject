package com.example.firstproject.api;

import com.example.firstproject.dto.CommentForm;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;


    // 조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentForm>> comments(@PathVariable Long articleId) {
        List<CommentForm> dtos = commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 생성
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentForm> create(@PathVariable Long articleId, @RequestBody CommentForm dto) {
        CommentForm comment = commentService.create(articleId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }

    // 수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentForm> update(@PathVariable Long id, @RequestBody CommentForm dto) {
        CommentForm comment = commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(comment);
    }

    // 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentForm> delete(@PathVariable Long id) {
        CommentForm comment = commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
