package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article getArticle(Long article_Id) {
        return articleRepository.findById(article_Id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article updateArticle(Long article_Id, Article article) {
        Article rs = articleRepository.findById(article_Id).orElseThrow(() -> new RuntimeException("Not Found"));
        rs.setArticle_Name(article.getArticle_Name());
        rs.setStocks(article.getStocks());
        articleRepository.save(rs);
        return rs;
    }

    public Article deleteArticle(Long article_Id) {
        Article rs = articleRepository.findById(article_Id).orElseThrow(() -> new RuntimeException("Not Found"));
        articleRepository.deleteById(article_Id);
        return rs;
    }


}
