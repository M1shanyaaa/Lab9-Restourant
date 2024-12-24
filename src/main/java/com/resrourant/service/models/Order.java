package com.resrourant.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dish;
    private int quantity;
    private String status;

    public Order() {}

    public Order(String dish, int quantity, String status) {
        this.dish = dish;
        this.quantity = quantity;
        this.status = status;
    }
}

