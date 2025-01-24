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
                AND p.price <= :maxPrice
                AND p.origin LIKE %:origin%
                AND p.species LIKE %:species%
                AND p.roastLevel LIKE %:roastLevel%
                AND p.tasted LIKE %:tasted%
                AND p.processing LIKE %:processing%
            """)
    public Page<Product> getAllProduct(BigDecimal minPrice, BigDecimal maxPrice, String origin, String species, String roastLevel, String tasted, String processing, Pageable pageable);
}
