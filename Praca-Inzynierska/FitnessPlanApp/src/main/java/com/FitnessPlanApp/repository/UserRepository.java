package com.FitnessPlanApp.repository;

import com.FitnessPlanApp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findByEmail(String email);
}
