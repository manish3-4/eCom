package com.example.eCOm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.eCOm.model.Category;
import com.example.eCOm.model.Product;

@Service
public class CategoryService {

    private final List<Category> categories;

    public CategoryService() {
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product(1L, "Laptop", 999.99, "High-performance laptop"));
        electronicsProducts.add(new Product(2L, "Smartphone", 699.99, "Latest smartphone with great camera"));

        List<Product> accessoriesProducts = new ArrayList<>();
        accessoriesProducts.add(new Product(3L, "Headphones", 149.99, "Noise-cancelling headphones"));
        accessoriesProducts.add(new Product(4L, "Keyboard", 79.99, "Mechanical gaming keyboard"));
        accessoriesProducts.add(new Product(5L, "Mouse", 49.99, "Ergonomic gaming mouse"));

        List<Product> computersProducts = new ArrayList<>();
        computersProducts.add(new Product(1L, "Laptop", 999.99, "High-performance laptop"));

        this.categories = new ArrayList<>();
        this.categories.add(new Category(1L, "Electronics", electronicsProducts));
        this.categories.add(new Category(2L, "Accessories", accessoriesProducts));
        this.categories.add(new Category(3L, "Computers", computersProducts));
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Optional<Category> getCategoryById(Long id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}