package com.FitnessPlanApp.service;

import com.FitnessPlanApp.model.Day;
import com.FitnessPlanApp.model.Workout;
import com.FitnessPlanApp.repository.DayRepository;
import com.FitnessPlanApp.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    DayRepository dayRepository;

    public List<Workout> getWorkoutList() {
        return workoutRepository.findAll();
    }

    public List<String> getWorkoutCategories() {
        List<Workout> workoutList = getWorkoutList();
        // zebranie wszystkich kategorii bez powtorzen z listy cwiczen
        return workoutList.stream().map(w->w.getCategory()).distinct().collect(Collectors.toList());
    }

    public List<Workout> getWorkoutListByCategory(String category){
        return workoutRepository.findAllByCategory(category);
    }

    public Workout getWorkout(String id) {
        return workoutRepository.findById(Integer.valueOf(id)).get();
    }

    public void removeWorkout(String workoutId) {
        // usuniecie cwiczenia ze wszystkich dni wszystkich planow kazdego uzytkownika
        Workout workoutToRemove = workoutRepository.findById(Integer.valueOf(workoutId)).get();
        List<Day> dayList = dayRepository.findAll();
        for(Day day : dayList){
            if(day.getWorkoutList().contains(workoutToRemove)){
                List<Workout> workoutList = day.getWorkoutList();
                workoutList.remove(workoutToRemove);
                day.setWorkoutList(workoutList);
                dayRepository.save(day);
            }
        }
        workoutRepository.delete(workoutRepository.findById(Integer.valueOf(workoutId)).get());
    }

    public void addWorkout(String category, String name, String description, String videoLink) {
        Workout workout = new Workout(null, category, name, description, videoLink, null);
        workoutRepository.save(workout);
    }

    public void addWorkoutToPlan(String workoutId, String dayId) {
        Day day = dayRepository.findById(Integer.valueOf(dayId)).get();
        Workout workout = workoutRepository.findById(Integer.valueOf(workoutId)).get();
        List<Workout> workoutList = day.getWorkoutList();
        workoutList.add(workout);
        day.setWorkoutList(workoutList);
        dayRepository.save(day);
    }

    public void editWorkout(String category, String name, String description, String videoLink, String workoutId){
        Workout workout = workoutRepository.findById(Integer.valueOf(workoutId)).get();
        workout.setCategory(category);
        workout.setName(name);
        workout.setDescription(description);
        workout.setVideoLink(videoLink);
        workoutRepository.save(workout);
    }
}
