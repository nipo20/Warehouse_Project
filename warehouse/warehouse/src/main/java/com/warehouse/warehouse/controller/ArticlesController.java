package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    //Add article into inventory
    @PostMapping("/article")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article addedArticle = articleService.addArticle(article);
        return new ResponseEntity<>(addedArticle, HttpStatus.CREATED);
    }

    //Retrieve an Article by article_Id
    @GetMapping("/article/{article_Id}")
    public ResponseEntity<Article> getArticle(@PathVariable("article_Id") Long article_Id) {
        Article getAnArticles = (Article) articleService.getArticle(article_Id);
        return new ResponseEntity<>(getAnArticles, HttpStatus.OK);
    }

    //Retrieve all the articles
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    //Update an Article using article_Id
    @PutMapping("/article")
    public ResponseEntity<Article> updateArticle(@RequestParam(name = "article_Id") Long article_Id, @RequestBody Article article) {
        Article updatedArticle = articleService.updateArticle(article_Id, article);
        return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
    }

    //Delete an Article using article_Id
    @DeleteMapping("/article")
    public ResponseEntity<Article> deleteArticle(@RequestParam(name = "article_Id") Long article_Id) {
        Article deletedArticle = articleService.deleteArticle(article_Id);
        return new ResponseEntity<>(deletedArticle, HttpStatus.OK);
    }
}
