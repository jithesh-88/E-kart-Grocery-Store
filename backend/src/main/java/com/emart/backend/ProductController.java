package com.emart.backend;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000") // for React later
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // ✅ CREATE (Add product)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // ✅ READ ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // ✅ READ ONE
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            return repo.save(existing);
        }

        return null;
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
    }
}