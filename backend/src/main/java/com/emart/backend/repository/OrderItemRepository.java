package com.emart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.backend.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}