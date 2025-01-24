package com.folkatechtest.folkatechtest.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.folkatechtest.folkatechtest.helpers.ProductMapper;
import com.folkatechtest.folkatechtest.models.dtos.ProductDto;
import com.folkatechtest.folkatechtest.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDto> getAllProduct(String sortBy, String sort, int pageNumber, int pageSize, BigDecimal minPrice) {
        Direction sortDirection = sort.equals("asc") || sort.isEmpty() ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pagination = PageRequest.of(pageNumber - 1, pageSize).withSort(sortDirection, sortBy);
        var products = productRepository.getAllProduct(minPrice, pagination);
        var productDtos = products.map(e -> ProductMapper.toProductDto(e));
        return productDtos;
    }

    public ProductDto getProductById(int productId) {
        var product = productRepository.findById(productId).get();
        var productDto = ProductMapper.toProductDto(product);
        return productDto;
    }
}
