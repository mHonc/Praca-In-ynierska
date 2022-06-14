package com.FitnessPlanApp.repository;

import com.FitnessPlanApp.model.Day;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {

    List<Day> findAll();
}
