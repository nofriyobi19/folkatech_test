package com.folkatechtest.folkatechtest.models.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductGridDto {
    private int productId;

    private String name;

    private double rating;

    private BigDecimal price;

    private String imagePath;
}
