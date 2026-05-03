package com.emart.backend.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.emart.backend.entity.Product;
import com.emart.backend.entity.StockUpdate;
import com.emart.backend.repository.ProductRepository;
import com.emart.backend.repository.StockUpdateRepository;

@Service
public class StockService {

    private final StockUpdateRepository stockRepo;
    private final ProductRepository productRepo;

    public StockService(StockUpdateRepository stockRepo, ProductRepository productRepo) {
        this.stockRepo = stockRepo;
        this.productRepo = productRepo;
    }

    public String addStock(Long productId, Long supplierId, int qty) {

        Product product = productRepo.findById(productId).orElse(null);

        if (product == null) {
            return "❌ Product not found";
        }

        // update stock
        product.setStockQuantity(product.getStockQuantity() + qty);
        productRepo.save(product);

        // log stock update
        StockUpdate su = new StockUpdate();
        su.setProduct_id(productId);
        su.setSupplier_id(supplierId);
        su.setQuantity_added(qty);
        su.setUpdate_date(LocalDateTime.now());

        stockRepo.save(su);

        return "✅ Stock added successfully";
    }
}