package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticle(Model model){

        return "articles/new";
    }

    @PostMapping("/articles/create")
        public String createArticle(ArticleForm form){
            System.out.println(form.toString());

            //1. DTO를 Entity로 변환
            Article article = form.toEntity();
//        System.out.println(article.toString()); //DTO가 Entity로 잘 변환되는지 확인 출력
            log.info(form.toString());

            //2. Entity를 Repository로 DB에 저장
            Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());//article이 DB에 잘 저장되는지 확인 출력
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        //1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null); //Optional<Article> articleEntity = articleRepository.findById(id); 도 가능
        //2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article", articleEntity);
        //3. 사용자에게 데이터 보여주기 위해 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1. DB에서 모든 Article 데이터 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //2. 가져온 데이터 모델에 등록하기
        model.addAttribute("articleList", articleEntityList);
        //3. 뷰 페이지 설정하기
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form, Model model) {
        //1. DTO를 Entity로 변환하기
        log.info(form.toString());
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        //2. Entity를 DB에 저장하기
        //2-1. DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        //2-2. 기존 데이터값을 갱신하기
        if (target != null)
            articleRepository.save(articleEntity);

        return "redirect:/articles/" + target.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("게시글 삭제 요청");
        //1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        //2. 대상 엔티티 삭제하기
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
        }
        //3. 결과 페이지로 리다이렉트하기
        return "redirect:/articles";
    }
}
