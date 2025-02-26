package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.model.ProductData;
import com.warehouse.warehouse.model.Products;
import com.warehouse.warehouse.repository.ArticleRepository;
import com.warehouse.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public Products addProduct(ProductData productsData) {
        List<Article> articles = articleRepository.getArticleByListofId(productsData.getArticle_Id());
        Products product = new Products();
        product.setProduct_Name(productsData.getProduct_Name());
        product.setArticle(articles);
        return productRepository.save(product);
    }

    public Products getProduct(Long product_Id) {
        return productRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }


    public Products updateProduct(Long product_Id, Products updatedProduct) {
        Products existingProduct = productRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setProduct_Name(updatedProduct.getProduct_Name());
        existingProduct.getArticle().clear();

        List<Article> updatedArticles = updatedProduct.getArticle();
        for (Article article : updatedArticles) {
            article.setProducts(existingProduct);
        }

        existingProduct.setArticle(updatedArticles);
        return productRepository.save(existingProduct);
    }

    public Products deleteProduct(Long product_Id) {
        Products rs = productRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(product_Id);
        return rs;
    }
}
