package com.FitnessPlanApp.service;

import com.FitnessPlanApp.model.Day;
import com.FitnessPlanApp.model.Plan;
import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.model.Workout;
import com.FitnessPlanApp.repository.DayRepository;
import com.FitnessPlanApp.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    WorkoutService workoutService;

    public List<Plan> getList() {
        return planRepository.findAll();
    }

    public List<Plan> getListByUser(User user) {
        return planRepository.findAllByUser(user);
    }

    public Plan get(String planId) {
        return planRepository.findById(Integer.valueOf(planId)).get();
    }

    public void add(HttpServletRequest req, String name, String description) {
        User userSession = (User) req.getSession().getAttribute("user");
        Plan plan = new Plan(null, name, description, userSession, null, false);
        addDaysToPlan(planRepository.save(plan));
    }

    public void addDaysToPlan(Plan plan) {
        Day monday = new Day(null, "Poniedziałek", plan, null);
        Day tuesday = new Day(null, "Wtorek", plan, null);
        Day wednesday = new Day(null, "Sroda", plan, null);
        Day thursday = new Day(null, "Czwartek", plan, null);
        Day friday = new Day(null, "Piątek", plan, null);
        Day saturday = new Day(null, "Sobota", plan, null);
        Day sunday = new Day(null, "Niedziela", plan, null);

        dayRepository.save(monday);
        dayRepository.save(tuesday);
        dayRepository.save(wednesday);
        dayRepository.save(thursday);
        dayRepository.save(friday);
        dayRepository.save(saturday);
        dayRepository.save(sunday);
    }

    public void remove(String planId) {
        planRepository.delete(planRepository.findById(Integer.valueOf(planId)).get());
    }

    public void removeWorkoutFromPlan(String workoutId, String dayId){
        Day day = dayRepository.findById(Integer.valueOf(dayId)).get();
        Workout workout = workoutService.getWorkout(workoutId);
        day.getWorkoutList().remove(workout);
        dayRepository.save(day);
    }

    public void editPlan(String planId, String name, String description){
        Plan plan = get(planId);
        plan.setName(name);
        plan.setDescription(description);
        planRepository.save(plan);
    }
}
