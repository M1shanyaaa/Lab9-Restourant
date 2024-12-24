package com.resrourant.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents an order in the restaurant system.
 * This class stores the details of an order, including the dish, quantity, and order status.
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dish;
    private int quantity;
    private String status;

    /**
     * Default constructor for the Order class.
     * This constructor is required by JPA for entity instantiation.
     */
    public Order() {}

    /**
     * Constructor for creating a new Order instance with specified dish, quantity, and status.
     *
     * @param dish the name of the dish ordered
     * @param quantity the quantity of the dish ordered
     * @param status the status of the order (e.g., "Pending", "Completed")
     */
    public Order(String dish, int quantity, String status) {
        this.dish = dish;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and setters (optional for documentation)

    /**
     * Gets the ID of the order.
     *
     * @return the ID of the order
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id the ID to set for the order
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the dish ordered.
     *
     * @return the name of the dish
     */
    public String getDish() {
        return dish;
    }

    /**
     * Sets the name of the dish ordered.
     *
     * @param dish the name to set for the dish
     */
    public void setDish(String dish) {
        this.dish = dish;
    }

    /**
     * Gets the quantity of the dish ordered.
     *
     * @return the quantity of the dish
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the dish ordered.
     *
     * @param quantity the quantity to set for the dish
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the status of the order.
     *
     * @return the status of the order
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     *
     * @param status the status to set for the order
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
