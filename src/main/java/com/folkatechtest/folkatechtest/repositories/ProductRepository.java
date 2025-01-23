package com.folkatechtest.folkatechtest.repositories;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.folkatechtest.folkatechtest.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("""
            SELECT p
            FROM Product p
            WHERE p.price >= :minPrice
            """)
    public Page<Product> getAllProduct(BigDecimal minPrice, Pageable pageable);
}
