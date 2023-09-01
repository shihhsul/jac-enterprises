package com.jec.api.controllers;

import java.util.List;
import java.util.Random;

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
    NasaService nasaServ;

    @PostMapping("/new")
    public void addArticle(@RequestBody NasaArticle Article) {
        this.nasaServ.createArticle(Article);
    }

    @GetMapping("/findall")
    public List<NasaArticle> findAllArticles() {
        return this.nasaServ.getAllArticles();
    }

    @GetMapping("/{id}")
    public NasaArticle findArticleById(@PathVariable Integer id) {
        return this.nasaServ.getArticleById(id);
    }

    @PutMapping("/modify/{id}")
    public NasaArticle modifyArticle(@PathVariable Integer id, @RequestBody NasaArticle updatedArticle) {
        return this.nasaServ.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/delete/{id}")
    public void removeArticle(@PathVariable Integer id) {
        this.nasaServ.deleteArticleById(id);
    }

    @GetMapping("/random")
    public NasaArticle getRandom() {
        List<NasaArticle> arr = this.nasaServ.getAllArticles();
        Random random = new Random();
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }
}
