package com.FitnessPlanApp.repository;

import com.FitnessPlanApp.model.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface WorkoutRepository extends CrudRepository<Workout, Integer> {

    List<Workout> findAll();

    List<Workout> findAllByCategory(String category);

}
