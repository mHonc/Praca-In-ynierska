package com.FitnessPlanApp.view;

import com.FitnessPlanApp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeViewController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("home")
    public ModelAndView homeView(Model model) {
        model.addAttribute("categoryList", workoutService.getWorkoutCategories());
        return new ModelAndView("home");
    }

    @GetMapping("categoryWorkout")
    public ModelAndView categoryWorkoutView(Model model, String category){
        model.addAttribute("workoutList", workoutService.getWorkoutListByCategory(category));
        return new ModelAndView("categoryWorkout");
    }
}