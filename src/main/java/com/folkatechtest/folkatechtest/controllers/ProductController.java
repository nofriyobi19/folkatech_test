package com.folkatechtest.folkatechtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.folkatechtest.folkatechtest.models.dtos.ProductDto;
import com.folkatechtest.folkatechtest.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list-product")
    public List<ProductDto> getAllProducts() {
        var products = service.getAllProduct();
        return products;
    }
    
}
