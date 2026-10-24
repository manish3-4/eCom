package com.example.eCOm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.eCOm.service.CartService;
import java.util.*;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addToCart(Long productId, Model model) {
        cartService.addItem(productId);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(Long productId, Model model) {
        cartService.removeItem(productId);
        return "redirect:/cart";
    }
}