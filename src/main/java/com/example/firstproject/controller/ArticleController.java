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

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        //System.out.println(form.toString()); >> loging 기능으로 대체

        // 1. Dto를 변환! -> Entity!
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());
        // 2. Repository에게 Entity를 DB안에 저장하게함.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());

        return "redirect:/articles/"+ saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1: id로 데이터를 가져옴!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2: 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        // 3: 보여줄 페이지를 설정!
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model) {
        // 1: 모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        // 2: 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList",articleEntityList);
        // 3: 뷰 페이지를 설정!
        return "articles/index";

    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 모델에 데이터를 등록!
        model.addAttribute("article", articleEntity);


        // 뷰 페이지 설정
        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        // 1: DTO를 엔티티로 변환한다!
        Article articleEntity = form.toEntity();
        // 2: 엔티티를 DB로 저장한다!
        // 2-1: DB에서 기존 데이터를 가져온다.
        Article target =articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2: 기존 데이터에 값을 갱신한다!
        if(target != null){
            articleRepository.save(articleEntity);
        }

        // 3: 수정 결과 페이지로 리다이렉트 한다!
        return "articles/index";
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        // 1: 삭제 대상을 가져온다.
        Article target = articleRepository.findById(id).orElse(null);
        // 2: 대상을 삭제한다!
        if (target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
        }
        // 3: 결과 페이지로 리다이렉트 한다.
        return "redirect:/articles";

    }
}
