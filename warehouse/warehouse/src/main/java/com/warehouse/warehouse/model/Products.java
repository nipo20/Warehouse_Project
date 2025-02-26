package com.warehouse.warehouse.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name = "product_inventory")
@Data
@NoArgsConstructor
public class Products {

    @Id
    @Column(name = "product_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_Id;

    @Column(name = "product_Name", nullable = false)
    private String product_Name;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "product")
    private List<Article> article;

    @OneToOne
    @JoinColumn(name = "price")
    private Price price;

    public Products(Long product_Id, String product_Name, List<Article> article, Price price) {
        this.product_Id = product_Id;
        this.product_Name = product_Name;
        this.article = article;
        this.price = price;
    }

    public Long getProduct_Id() {
        return product_Id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public List<Article> getArticle() {
        return article;
    }

    public Price getPrice() {
        return price;
    }

}
