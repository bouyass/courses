package com.lyes.hibernate.services;

import com.lyes.hibernate.entities.Article;
import com.lyes.hibernate.repositories.IArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService{

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleDAO.getArticleById(articleId);
    }

    @Override
    public synchronized boolean addArticle(Article article) {
        if(articleDAO.articleExists(article.getTitle(),article.getCategory())){
            return false;
        }else{
            articleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}
