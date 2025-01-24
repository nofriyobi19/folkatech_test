package com.folkatechtest.folkatechtest.models.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private int productId;

    private String name;

    private String description;

    private String supplierName;

    private int stock;

    private BigDecimal price;

    private String origin;

    private String species;

    private String roastLevel;

    private String tasted;

    private String processing;

    private double rating;

    private boolean favorite;

    private List<String> imagePathList = new ArrayList<>();
}
