package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * FROM price_details WHERE product_Id=@product_Id", nativeQuery = true)
    List<Price> getPriceById(Long product_Id);
}
