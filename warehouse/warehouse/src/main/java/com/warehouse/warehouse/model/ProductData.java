package com.warehouse.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class ProductData {

    private String product_Name;

    private List<Long> article_Id;


    public ProductData(String product_Name, List<Long> article_Id) {
        this.product_Name = product_Name;
        this.article_Id = article_Id;
    }


    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public List<Long> getArticle_Id() {
        return article_Id;
    }

    public void setArticle_Id(List<Long> article_Id) {
        this.article_Id = article_Id;
    }
}
