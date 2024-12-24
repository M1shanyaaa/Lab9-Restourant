package com.resrourant.service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a user login entity in the system.
 * This class is used to store login credentials (name and password) in the database.
 */
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    /**
     * Default constructor for the Login class.
     * This is required by JPA for entity instantiation.
     */
    public Login() {}

    /**
     * Constructor for creating a new Login instance with specified name and password.
     *
     * @param name the name of the user
     * @param password the password of the user
     */
    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters and Setters (optional for documentation)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
