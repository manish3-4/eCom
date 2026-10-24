package com.example.eCOm.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Long id;
    private Map<Long, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Map<Long, Integer> getItems() { return items; }
    public void setItems(Map<Long, Integer> items) { this.items = items; }
}