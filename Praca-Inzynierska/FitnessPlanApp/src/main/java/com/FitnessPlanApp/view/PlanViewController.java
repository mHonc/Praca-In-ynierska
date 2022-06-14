package com.FitnessPlanApp.view;

import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlanViewController {

    @Autowired
    PlanService planService;

    @GetMapping("myPlan")
    public ModelAndView myPlanView(Model model, HttpServletRequest req) {
        User userSession = (User) req.getSession().getAttribute("user");
        model.addAttribute("planList", planService.getListByUser(userSession));
        return new ModelAndView("myPlan");
    }

    @GetMapping("addPlan")
    public ModelAndView addPlanView() {
        return new ModelAndView("addPlan");
    }

    @PostMapping("addPlan")
    public String addPlanView(HttpServletRequest req, String name, String description) {
        planService.add(req, name, description);
        return "redirect:myPlan";
    }

    @GetMapping("detailsPlan")
    public ModelAndView detailsPlanView(@RequestParam String planId, Model model, HttpServletRequest req) {
        model.addAttribute("plan", planService.get(planId));
        return new ModelAndView("detailsPlan");
    }

    @GetMapping("editPlan")
    public ModelAndView myPlanView(Model model, HttpServletRequest req, String planId) {
        model.addAttribute("plan", planService.get(planId));
        return new ModelAndView("editPlan");
    }

    @PostMapping("editPlan")
    public String editPlanView(String planId, String name, String description) {
        planService.editPlan(planId, name, description);
        return "redirect:home";
    }

    @PostMapping("removePlan")
    public String removePlanView(String planId) {
        planService.remove(planId);
        return "redirect:myPlan";
    }

    @GetMapping("removeWorkoutFromPlan")
    public String removeWorkoutFromPlanView(String workoutId, String dayId) {
        planService.removeWorkoutFromPlan(workoutId, dayId);
        return "redirect:myPlan";
    }
}
