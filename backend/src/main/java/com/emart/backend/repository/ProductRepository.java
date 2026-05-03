package com.emart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}