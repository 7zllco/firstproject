package com.example.firstproject.service;

import com.example.firstproject.dto.CommentForm;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    // 1. 댓글 조회
    public List<Comment> index(Long articleId) {
    }

    // 2. 댓글 생성
    public Comment create(Long articleId, CommentForm dto) {
    }

    // 3. 댓글 수정
    public Comment update(Long id) {
    }
    
    // 4. 댓글 삭제
    public Comment delete(Long id) {
    }
}
