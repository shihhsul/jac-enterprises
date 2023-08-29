package com.jec.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jec.api.entitites.Article;
import com.jec.api.services.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService ArticleServ;

    @PostMapping("/new")
    public void addArticle(@RequestBody Article Article) {
        this.ArticleServ.createArticle(Article);
    }

    @GetMapping("/findall")
    public List<Article> findAllArticles() {
        return this.ArticleServ.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article findArticleById(@PathVariable Integer id) {
        return this.ArticleServ.getArticleById(id);
    }

    @PutMapping("/modify/{id}")
    public Article modifyArticle(@PathVariable Integer id, @RequestBody Article updatedArticle) {
        return this.ArticleServ.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/delete/{id}")
    public void removeArticle(@PathVariable Integer id) {
        this.ArticleServ.deleteArticleById(id);
    }
}
