package com.warehouse.warehouse.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "price_details")
@Data
@NoArgsConstructor
public class Price {

    @Id
    @Column(name = "product_Id", unique = true)
    private Long product_Id;

    @Column(name = "price_Value")
    private Double price_Value;

    public Price(Long product_Id, Double price_Value) {
        this.product_Id = product_Id;
        this.price_Value = price_Value;
    }

    public Long getProduct_Id() {
        return product_Id;
    }

    public Double getPrice_Value() {
        return price_Value;
    }
}
