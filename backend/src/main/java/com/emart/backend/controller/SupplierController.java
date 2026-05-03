package com.emart.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.backend.entity.Supplier;
import com.emart.backend.repository.SupplierRepository;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(
            SupplierRepository supplierRepository
    ) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {

        return supplierRepository.findAll();
    }

    @PostMapping
    public Supplier addSupplier(
            @RequestBody Supplier supplier
    ) {

        return supplierRepository.save(supplier);
    }
}