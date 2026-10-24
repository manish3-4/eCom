package com.example.eCOm.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.eCOm.model.Product;

@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        this.products = Arrays.asList(
                new Product(1L, "Laptop", 999.99, "High-performance laptop"),
                new Product(2L, "Smartphone", 699.99, "Latest smartphone with great camera"),
                new Product(3L, "Headphones", 149.99, "Noise-cancelling headphones"),
                new Product(4L, "Keyboard", 79.99, "Mechanical gaming keyboard"),
                new Product(5L, "Mouse", 49.99, "Ergonomic gaming mouse")
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}