package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    //변수명이 mustache 파일의 form에서 받아오는 것들의 name 속성과 일치해야 자동으로 받기 가능
    private Long id;
    private String title;
    private String content;

    //롬복의 @AllArgsConstructor 애노테이션을 통해 간소화
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    //롬복의 @ToString 을 통해 간소화
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
