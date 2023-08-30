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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jec.api.entitites.BoredArticle;
import com.jec.api.entitites.NasaArticle;
import com.jec.api.services.NasaService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiRequestController {

    @Autowired
    NasaService articleServ;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/bored")
    public List<BoredArticle> getBored() {
        List<BoredArticle> output = new ArrayList<>();
        while (output.size() < 10) {
            HttpHeaders headers = new HttpHeaders();
            String apiUrl = "http://www.boredapi.com/api/activity/";
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET,
                    new HttpEntity<>(headers),
                    String.class);
            String response = responseEntity.getBody();
            JsonNode jsonElement;
            try {
                jsonElement = objectMapper.readTree(response);
                BoredArticle currentArticle = new BoredArticle();
                currentArticle.setActivity(jsonElement.get("activity").asText());
                currentArticle.setAccessibility(jsonElement.get("accessibility").asText());
                currentArticle.setLink(jsonElement.get("link").asText());
                currentArticle.setParticipants(jsonElement.get("participants").asText());
                output.add(currentArticle);
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return output;
    }

    @GetMapping("/NASA")
    public List<NasaArticle> getNASA() {
        List<NasaArticle> output = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        String apiKey = "9Ywd2QQ6znC1eOkRYRb3X0trteKgNO5D7LfKdejD";
        headers.set("api_key", apiKey);

        String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey
                + "&start_date=2023-08-01&end_date=2023-08-15";
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers),
                String.class);
        String response = responseEntity.getBody();

        try {
            JsonNode jsonArray = objectMapper.readTree(response);
            if (jsonArray.isArray()) {
                for (JsonNode jsonElement : jsonArray) {
                    String title = jsonElement.get("title").asText();
                    String explanation = jsonElement.get("explanation").asText();
                    String url = jsonElement.get("url").asText();
                    String author;
                    try {
                        author = jsonElement.get("copyright").asText();
                    } catch (Exception e) {
                        author = "PUBLIC IMAGE";
                    }

                    NasaArticle currentArticle = new NasaArticle();
                    author = author.replace("\n", " ");
                    currentArticle.setAuthor(author);
                    currentArticle.setImage(url);
                    currentArticle.setTitle(title);
                    currentArticle.setSummary(explanation);

                    output.add(currentArticle);
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return output;
    }
}