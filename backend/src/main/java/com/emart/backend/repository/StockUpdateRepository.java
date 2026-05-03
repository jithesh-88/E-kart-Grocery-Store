package com.emart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.entity.StockUpdate;

public interface StockUpdateRepository extends JpaRepository<StockUpdate, Long> {
}