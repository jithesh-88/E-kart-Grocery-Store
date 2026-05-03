package com.emart.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_updates")
public class StockUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long update_id;

    private Long product_id;
    private Long supplier_id;
    private int quantity_added;

    private LocalDateTime update_date;

    public Long getUpdate_id() { return update_id; }

    public void setUpdate_id(Long update_id) { this.update_id = update_id; }

    public Long getProduct_id() { return product_id; }

    public void setProduct_id(Long product_id) { this.product_id = product_id; }

    public Long getSupplier_id() { return supplier_id; }

    public void setSupplier_id(Long supplier_id) { this.supplier_id = supplier_id; }

    public int getQuantity_added() { return quantity_added; }

    public void setQuantity_added(int quantity_added) { this.quantity_added = quantity_added; }

    public LocalDateTime getUpdate_date() { return update_date; }

    public void setUpdate_date(LocalDateTime update_date) { this.update_date = update_date; }
}