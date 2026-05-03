package com.emart.backend.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final JdbcTemplate jdbcTemplate;

    public OrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String placeOrder(Long customerId,
                             Long productId,
                             int quantity) {

        try {

            jdbcTemplate.update(
                "CALL place_order(?, ?, ?)",
                customerId,
                productId,
                quantity
            );

            return "✅ Order placed successfully";

        } catch (Exception e) {

            return "❌ " + e.getMessage();
        }
    }
}