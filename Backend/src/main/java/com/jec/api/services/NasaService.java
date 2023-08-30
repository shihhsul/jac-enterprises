package com.jec.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jec.api.entitites.NasaArticle;
import com.jec.api.repositories.NasaArticleRepository;
import com.jec.api.controllers.ApiRequestController;

@Service
public class NasaService {

    @Autowired
    private NasaArticleRepository ArticleRepository;

    /*
     * Adds a new Article to the repository (db). The "C" (create) in CRUD
     */
    public void createArticle(NasaArticle article) {
        this.ArticleRepository.save(article);
    }

    /*
     * Gets all the Articles in the repo (db). The "R" (read) in CRUD
     */
    public List<NasaArticle> getAllArticles() {
        return ArticleRepository.findAll();
    }

    /*
     * Gets a specific Article by its id. The "R" (read) in CRUD
     */
    public NasaArticle getArticleById(Integer id) {

        Optional<NasaArticle> article = ArticleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        }
        return null;
    }

    /*
     * Updates an existing Article, found by a specific id. The "U" (update) in
     * CRUD
     */
    public NasaArticle updateArticle(Integer id, NasaArticle updatedVpet) {
        NasaArticle existingarticle = getArticleById(id);

        if (existingarticle != null) {
            // existingarticle.setBladder(updatedVpet.getBladder());
            // existingarticle.setDescription(updatedVpet.getDescription());
            // existingarticle.setExercise(updatedVpet.getExercise());
            // existingarticle.setHappiness(updatedVpet.getHappiness());
            // existingarticle.setHunger(updatedVpet.getHunger());
            // existingarticle.setThirst(updatedVpet.getThirst());
            ArticleRepository.save(existingarticle);
        }

        return null; // Return null if the article with the given ID is not found
    }

    /*
     * Delete a Article from the repo. The "D" (delete) in CRUD
     */
    public boolean deleteArticleById(Integer id) {
        if (ArticleRepository.existsById(id)) {
            ArticleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
