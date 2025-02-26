package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.model.Price;
import com.warehouse.warehouse.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    // Add Price details against Article
    @PostMapping("/price")
    public ResponseEntity<Price> addPrice(@RequestBody Price price) {
        Price addedPrice = priceService.addPrice(price);
        return new ResponseEntity<>(addedPrice, HttpStatus.CREATED);
    }

    // Retrieve Price details for each Article using articleID
    @GetMapping("/price/{product_Id}")
    public ResponseEntity<Price> getPrice(@PathVariable("product_Id") Long product_Id) {
        Price getAnArticlePrice = (Price) priceService.getPrice(product_Id);
        return new ResponseEntity<>(getAnArticlePrice, HttpStatus.OK);
    }

    // Retrieve Price details for list of all Articles
    @GetMapping("/prices")
    public List<Price> getAllProductPrice() {
        return priceService.getAllProductPrice();
    }

    // Update Price of each Article using articleID
    @PutMapping("/price")
    public ResponseEntity<Price> updatePrice(@RequestParam(name = "product_Id") Long product_Id, @RequestBody Price price) {
        Price updatedPrice = priceService.updatePrice(product_Id, price);
        return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
    }

    // Delete Price of each Article using articleID
    @DeleteMapping("/price")
    public ResponseEntity<Price> deletePrice(@RequestParam(name = "product_Id") long product_Id, Price price) {
        Price deletedPrice = priceService.deletePrice(product_Id);
        return new ResponseEntity<>(deletedPrice, HttpStatus.OK);
    }

}
