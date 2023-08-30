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
import com.jec.api.entitites.NasaArticle;
import com.jec.api.services.NasaService;

//a class designed to package data from api requests for easy use on frontend
@RestController
@RequestMapping("/api/nasa")
public class NasaArticleController {

    @Autowired
    NasaService ArticleServ;

    @PostMapping("/new")
    public void addArticle(@RequestBody NasaArticle Article) {
        this.ArticleServ.createArticle(Article);
    }

    @GetMapping("/findall")
    public List<NasaArticle> findAllArticles() {
        return this.ArticleServ.getAllArticles();
    }

    @GetMapping("/{id}")
    public NasaArticle findArticleById(@PathVariable Integer id) {
        return this.ArticleServ.getArticleById(id);
    }

    @PutMapping("/modify/{id}")
    public NasaArticle modifyArticle(@PathVariable Integer id, @RequestBody NasaArticle updatedArticle) {
        return this.ArticleServ.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/delete/{id}")
    public void removeArticle(@PathVariable Integer id) {
        this.ArticleServ.deleteArticleById(id);
    }
}
