package com.lyes.hibernate.services;

import com.lyes.hibernate.entities.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);

}
