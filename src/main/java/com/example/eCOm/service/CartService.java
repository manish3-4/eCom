package com.example.eCOm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final Map<Long, Integer> cartItems = new HashMap<>();

    public CartService() {
        // Initialize with some items
        cartItems.put(1L, 0);
        cartItems.put(2L, 0);
        cartItems.put(3L, 0);
    }

    public Map<Long, Integer> getCart() {
        return new HashMap<>(cartItems);
    }

    public void addItem(Long productId) {
        Integer quantity = cartItems.get(productId);
        cartItems.put(productId, quantity == null ? 1 : quantity + 1);
    }

    public void removeItem(Long productId) {
        cartItems.computeIfPresent(productId, (k, v) -> v > 1 ? v - 1 : null);
    }
}