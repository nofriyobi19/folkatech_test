package com.folkatechtest.folkatechtest.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.folkatechtest.folkatechtest.models.dtos.ProductDto;
import com.folkatechtest.folkatechtest.models.dtos.ProductGridDto;
import com.folkatechtest.folkatechtest.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("list-product")
    public Page<ProductGridDto> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                               @RequestParam(defaultValue = "") String sort,
                                               @RequestParam(defaultValue = "1") int pageNumber,
                                               @RequestParam(defaultValue = "9") int pageSize,
                                               @RequestParam(defaultValue = "0") BigDecimal minPrice,
                                               @RequestParam(defaultValue = "9999999999") BigDecimal maxPrice,
                                               @RequestParam(defaultValue = "") String origin,
                                               @RequestParam(defaultValue = "") String species,
                                               @RequestParam(defaultValue = "") String roastLevel,
                                               @RequestParam(defaultValue = "") String tasted,
                                               @RequestParam(defaultValue = "") String processing) {
        var products = service.getAllProduct(sortBy, sort, pageNumber, pageSize, minPrice, maxPrice, origin, species, roastLevel, tasted, processing);
        return products;
    }

    @GetMapping("product/{id}")
    public ProductDto GetProductById(@PathVariable int id) {
        var product = service.getProductById(id);
        return product;
    }
    
    
}
