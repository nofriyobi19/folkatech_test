package com.folkatechtest.folkatechtest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.folkatechtest.folkatechtest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
