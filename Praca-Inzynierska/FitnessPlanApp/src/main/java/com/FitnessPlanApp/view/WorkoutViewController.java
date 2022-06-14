package com.FitnessPlanApp.view;

import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.service.PlanService;
import com.FitnessPlanApp.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkoutViewController {

    @Autowired
    WorkoutService workoutService;

    @Autowired
    PlanService planService;

    @GetMapping("addWorkout")
    public ModelAndView addWorkoutView() {
        return new ModelAndView("addWorkout");
    }

    @GetMapping("detailsWorkout")
    public ModelAndView detailsWorkoutView(@RequestParam String workoutId, Model model, HttpServletRequest req) {
        model.addAttribute("workout", workoutService.getWorkout(workoutId));
        model.addAttribute("planList", planService.getListByUser((User) req.getSession().getAttribute("user")));
        return new ModelAndView("detailsWorkout");
    }

    @GetMapping("editWorkout")
    public ModelAndView editWorkoutView(String workoutId, Model model){
        model.addAttribute("workout", workoutService.getWorkout(workoutId));
        return new ModelAndView("editWorkout");
    }

    @PostMapping("addWorkout")
    public String addWorkoutView(String category, String name, String description, String videoLink) {
        workoutService.addWorkout(category, name, description, videoLink);
        return "redirect:home";
    }

    @PostMapping("removeWorkout")
    public String removeWorkoutView(String workoutId) {
        workoutService.removeWorkout(workoutId);
        return "redirect:home";
    }

    @PostMapping("editWorkout")
    public String editWorkoutView(String category, String name, String description, String videoLink, String workoutId){
        workoutService.editWorkout(category, name, description, videoLink, workoutId);
        return "redirect:home";
    }

    @GetMapping("addWorkoutToPlan")
    public String addWorkoutToPlan(String workoutId, String dayId) {
        workoutService.addWorkoutToPlan(workoutId, dayId);
        return "redirect:home";
    }
}
