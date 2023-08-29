package com.jec.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jec.api.entitites.Article;
import com.jec.api.services.ArticleService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiRequestController {

    @Autowired
    ArticleService articleServ;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/artworks")
    public List<Article> getArtworks() {

        List<Article> articles = new ArrayList<>();

        String apiUrl = "https://collectionapi.metmuseum.org/public/collection/v1/objects?departmentIds=5";
        String response = restTemplate.getForObject(apiUrl, String.class);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        converters.add(converter);
        restTemplate.setMessageConverters(converters);

        try {
            JsonNode responseData = objectMapper.readTree(response);
            List<Integer> objectIds = new ArrayList<>();
            responseData.get("objectIDs").forEach(id -> objectIds.add(id.asInt()));

            while (articles.size()<10){
                Random random = new Random();
                int randomIndex = random.nextInt(objectIds.size());
                int randomId = objectIds.remove(randomIndex);

                String apiUrl2 = "https://collectionapi.metmuseum.org/public/collection/v1/objects/" + randomId;
                String response2 = restTemplate.getForObject(apiUrl2, String.class);

                JsonNode currentResponseData = objectMapper.readTree(response2);
                Article currentArticle = new Article();
                currentArticle.setTitle(currentResponseData.get("title").asText());
                currentArticle.setAuthor(currentResponseData.get("artistDisplayName").asText());
                currentArticle.setSummary(null);
                currentArticle.setImage(currentResponseData.get("primaryImage").asText());
                if(currentArticle.getTitle()!=""&&currentArticle.getAuthor()!=""&&currentArticle.getImage()!=""){
                    articles.add(currentArticle);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articles;
    }
}
