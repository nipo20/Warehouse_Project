package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.model.ProductData;
import com.warehouse.warehouse.model.Products;
import com.warehouse.warehouse.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Retrieve a product detail using ID
    @GetMapping("/product/{product_Id}")
    public ResponseEntity<Products> getProduct(@PathVariable("product_Id") Long product_Id) {
        Products getProductdetails = (Products) productService.getProduct(product_Id);
        return new ResponseEntity<>(getProductdetails, HttpStatus.OK);
    }

    //Retrieve all products
    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    //Add product to the list
    @PostMapping("/product")
    public ResponseEntity<Products> addProduct(@RequestBody ProductData productData) {
        Products addedProducts = productService.addProduct(productData);
        return new ResponseEntity<>(addedProducts, HttpStatus.CREATED);
    }

    //Update product using ID 
    @PutMapping("/product/{product_Id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long product_Id, @RequestBody Products updatedProduct) {
        Products updatedProd = productService.updateProduct(product_Id, updatedProduct);
        return new ResponseEntity<>(updatedProd, HttpStatus.OK);
    }

    //Delete a product using ID 
    @DeleteMapping("/product")
    public ResponseEntity<Products> deleteProduct(@RequestParam(name = "product_Id") Long product_Id) {
        Products deleteProductById = productService.deleteProduct(product_Id);
        return new ResponseEntity<>(deleteProductById, HttpStatus.OK);
    }
}
