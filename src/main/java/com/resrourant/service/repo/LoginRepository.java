package com.resrourant.service.repo;

import com.resrourant.service.models.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Long> {
    Login findByName(String name);
}