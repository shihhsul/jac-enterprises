package com.jec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jec.api.entitites.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
