package com.warehouse.warehouse.service;

import com.warehouse.warehouse.model.Article;
import com.warehouse.warehouse.model.Price;
import com.warehouse.warehouse.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price addPrice(Price price) {
        return priceRepository.save(price);
    }

    public Price getPrice(Long product_Id) {
        return priceRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Price> getAllProductPrice() {
        return priceRepository.findAll();
    }

    public Price updatePrice(Long product_Id, Price price) {
        Price rs = priceRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Not Found"));
        rs.setPrice_Value(price.getPrice_Value());
        priceRepository.save(rs);
        return rs;
    }

    public Price deletePrice(Long product_Id) {
        Price rs = priceRepository.findById(product_Id).orElseThrow(() -> new RuntimeException("Not Found"));
        priceRepository.deleteById(product_Id);
        return rs;
    }

}
