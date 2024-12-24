package com.resrourant.service.repo;

import com.resrourant.service.models.Menu;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for managing {@link Menu} entities.
 * Provides CRUD operations for storing and retrieving menu data from the database.
 */
public interface MenuRepository extends CrudRepository<Menu, Long> {
}
