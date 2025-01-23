package com.folkatechtest.folkatechtest.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProductDto> getAllProduct(String sortBy, String sort, int pageNumber, int pageSize, BigDecimal minPrice) {
        Direction sortDirection = sort.equals("asc") || sort.isEmpty() ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pagination = PageRequest.of(pageNumber - 1, pageSize).withSort(sortDirection, sortBy);
        var products = productRepository.getAllProduct(minPrice, pagination);
        var productDtos = products.stream().map(e -> ProductMapper.toProductDto(e)).collect(Collectors.toList());
        return productDtos;
    }
}
