package com.emart.backend.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class StockController {

    private final JdbcTemplate jdbcTemplate;

    public StockController(
            JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/add")
    public String addStock(

            @RequestParam Long productId,

            @RequestParam Long supplierId,

            @RequestParam int quantity
    ) {

        try {

            // INSERT INTO STOCK UPDATES TABLE

            jdbcTemplate.update(

                """
                INSERT INTO stock_updates(
                    product_id,
                    supplier_id,
                    quantity_added
                )
                VALUES (?, ?, ?)
                """,

                productId,
                supplierId,
                quantity
            );

            // UPDATE PRODUCT STOCK

            jdbcTemplate.update(

                """
                UPDATE products
                SET stock_quantity =
                    stock_quantity + ?
                WHERE product_id = ?
                """,

                quantity,
                productId
            );

            return "✅ Stock Added Successfully";

        } catch (Exception e) {

            return "❌ " + e.getMessage();
        }
    }
}