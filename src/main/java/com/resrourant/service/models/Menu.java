package com.resrourant.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a menu item in the restaurant.
 * This class stores the details of a dish, including its name, price, and readiness status.
 */
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dish;
    private String price;
    private String readiness;

    /**
     * Default constructor for the Menu class.
     * This constructor is required by JPA for entity instantiation.
     */
    public Menu() {
    }

    /**
     * Constructor for creating a new Menu instance with the specified dish name, price, and readiness.
     *
     * @param dish the name of the dish
     * @param price the price of the dish
     * @param readiness the readiness status of the dish (e.g., "Available", "Not Available")
     */
    public Menu(String dish, String price, String readiness) {
        this.dish = dish;
        this.price = price;
        this.readiness = readiness;
    }

    /**
     * Gets the ID of the menu item.
     *
     * @return the ID of the menu item
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the menu item.
     *
     * @param id the ID to set for the menu item
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the dish.
     *
     * @return the name of the dish
     */
    public String getDish() {
        return dish;
    }

    /**
     * Sets the name of the dish.
     *
     * @param dish the name to set for the dish
     */
    public void setDish(String dish) {
        this.dish = dish;
    }

    /**
     * Gets the price of the dish.
     *
     * @return the price of the dish
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the price of the dish.
     *
     * @param price the price to set for the dish
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets the readiness status of the dish.
     *
     * @return the readiness status of the dish
     */
    public String getReadiness() {
        return readiness;
    }

    /**
     * Sets the readiness status of the dish.
     *
     * @param readiness the readiness status to set for the dish
     */
    public void setReadiness(String readiness) {
        this.readiness = readiness;
    }
}
