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

import com.jec.api.entitites.BoredArticle;
import com.jec.api.entitites.BoredArticle;
import com.jec.api.services.BoredService;

//a class designed to package data from api requests for easy use on frontend
@RestController
@RequestMapping("/api/bored")
public class BoredArticleController {

    @Autowired
    BoredService boredServ;

    @PostMapping("/new")
    public void addArticle(@RequestBody BoredArticle Article) {
        this.boredServ.createArticle(Article);
    }

    @GetMapping("/findall")
    public List<BoredArticle> findAllArticles() {
        return this.boredServ.getAllArticles();
    }

    @GetMapping("/{id}")
    public BoredArticle findArticleById(@PathVariable Integer id) {
        return this.boredServ.getArticleById(id);
    }

    @PutMapping("/modify/{id}")
    public BoredArticle modifyArticle(@PathVariable Integer id, @RequestBody BoredArticle updatedArticle) {
        return this.boredServ.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/delete/{id}")
    public void removeArticle(@PathVariable Integer id) {
        this.boredServ.deleteArticleById(id);
    }
}
