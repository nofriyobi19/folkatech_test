package com.folkatechtest.folkatechtest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folkatechtest.folkatechtest.helpers.ProductMapper;
import com.folkatechtest.folkatechtest.models.dtos.ProductDto;
import com.folkatechtest.folkatechtest.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAllProduct() {
        var products = productRepository.findAll();
        var productDtos = products.stream().map(e -> ProductMapper.toProductDto(e)).collect(Collectors.toList());
        return productDtos;
    }
}
