package com.lyes.hibernate.repositories;

import com.lyes.hibernate.entities.Article;

import java.util.List;

public interface IArticleDAO {

    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleID);
    boolean articleExists(String title, String category);
}
