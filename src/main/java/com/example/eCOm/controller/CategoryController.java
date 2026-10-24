package com.example.eCOm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.eCOm.service.CategoryService;
import java.util.*;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/category/products")
    public String categoryProducts(Model model, Long id) {
        return categoryService.getCategoryById(id)
                .map(category -> {
                    model.addAttribute("products", category.getProducts());
                    model.addAttribute("category", category.getName());
                    return "category-products";
                })
                .orElse("redirect:/categories");
    }
}