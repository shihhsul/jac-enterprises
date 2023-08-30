package com.jec.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jec.api.repositories.BoredArticleRepository;
import com.jec.api.repositories.NasaArticleRepository;
import com.jec.api.controllers.ApiRequestController;
import com.jec.api.entitites.BoredArticle;
import com.jec.api.entitites.NasaArticle;

@Component
public class population implements CommandLineRunner {
    @Autowired
    private NasaArticleRepository nasaRepositiory;
    @Autowired
    private BoredArticleRepository boredRepository;

    @Override
    public void run(String... args) throws Exception {
        ApiRequestController controller = new ApiRequestController();
        List<BoredArticle> boredArticles = controller.getBored();
        List<NasaArticle> nasaArticles = controller.getNASA();
        boredRepository.saveAll(boredArticles);
        nasaRepositiory.saveAll(nasaArticles);
    }
}
