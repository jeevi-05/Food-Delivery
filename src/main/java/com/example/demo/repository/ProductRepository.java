package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    Page<Product> findByCategory(String category, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN p.stockList s WHERE s.quantity < :threshold")
    Page<Product> findLowStockProducts(int threshold, Pageable pageable);
}
