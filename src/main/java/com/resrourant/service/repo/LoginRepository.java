package com.resrourant.service.repo;

import com.resrourant.service.models.Login;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing {@link Login} entities.
 * Provides CRUD operations for storing and retrieving login data from the database.
 */
public interface LoginRepository extends CrudRepository<Login, Long> {

    /**
     * Finds a {@link Login} entity by its name.
     *
     * @param name the name of the user to search for
     * @return the {@link Login} entity matching the provided name, or null if not found
     */
    Login findByName(String name);
}
