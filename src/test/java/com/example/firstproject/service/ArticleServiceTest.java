package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // 1. 예상 데이터 작성
        Article a = new Article(1L,"어제", "잘 쉬었다");
        Article b = new Article(2L,"오늘","열심히 했다");
        Article c = new Article(3L,"내일","열심히 한다");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));
        // 2. 실제 데이터 획득
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }


    @Test
    void show_성공() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "어제", "잘 쉬었다");
        // 2. 실제 데이터
        Article article =articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력() {
        Long id = -1L;
        Article expected = null;

        Article article = articleService.show(id);

        assertEquals(expected, article);
    }

    @Test
    void create_성공() {
        String title = "우와";
        String content = "피곤해";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void create_실패() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}