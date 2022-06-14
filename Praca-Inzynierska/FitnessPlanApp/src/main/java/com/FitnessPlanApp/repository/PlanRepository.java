package com.FitnessPlanApp.repository;

import com.FitnessPlanApp.model.Plan;
import com.FitnessPlanApp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<Plan, Integer> {

    List<Plan> findAll();

    List<Plan> findAllByUser(User user);

    List<Plan> findAllByShared(Boolean isShare);
}
