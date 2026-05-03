package com.emart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.entity.Order;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}