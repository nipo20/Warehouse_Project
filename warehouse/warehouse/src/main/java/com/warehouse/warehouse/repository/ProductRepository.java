package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT pi.product_Id,pi.product_Name,ai.article_Id,ai.article_Name,ai.stocks,pd.price_value FROM product_inventory pi INNER JOIN article_inventory ai ON pi.product_Id = ai.product_Id INNER JOIN price_details pd pi.product_Id = pd.product_Id  WHERE product_Id=@product_Id", nativeQuery = true)
    List<Products> getProductById(Long product_Id);
}
