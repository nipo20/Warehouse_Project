package com.warehouse.warehouse.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Table(name = "articles_inventory")
@Data
@NoArgsConstructor
@Setter
public class Article {

    @Id
    @Column(name = "article_Id", nullable = false)
    private Long article_Id;
    @Column(name = "article_Name", nullable = false)
    private String article_Name;
    @Column(name = "stocks")
    private Integer stocks;

    @ManyToOne
    @JoinColumn(name = "product")
    private Products products;

    public Article(Long article_Id, String article_Name, Integer stocks, Products products) {
        this.article_Id = article_Id;
        this.article_Name = article_Name;
        this.stocks = stocks;
        this.products = products;
    }

    public Long getArticle_Id() {
        return article_Id;
    }

    public String getArticle_Name() {
        return article_Name;
    }

    public Integer getStocks() {
        return stocks;
    }

    public Products getProducts() {
        return products;
    }
}