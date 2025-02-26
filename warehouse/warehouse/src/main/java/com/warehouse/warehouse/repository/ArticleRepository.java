package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM articles_inventory  WHERE article_Id IN (:article_Id)", nativeQuery = true)
    List<Article> getArticleByListofId(@Param("article_Id") List<Long> article_Id);
}

