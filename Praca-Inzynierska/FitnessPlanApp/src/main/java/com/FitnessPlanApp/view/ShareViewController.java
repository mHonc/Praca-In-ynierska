package com.FitnessPlanApp.view;

import com.FitnessPlanApp.model.Plan;
import com.FitnessPlanApp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShareViewController {

    @Autowired
    ShareService shareService;

    @PostMapping("sharePlan")
    public String addPlanView(String planId) {
        shareService.share(planId);
        return "redirect:sharePlan";
    }

    @PostMapping("removeSharePlan")
    public String removeSharePlanView(String planId) {
        shareService.unshare(planId);
        return "redirect:sharePlan";
    }

    @GetMapping("sharePlan")
    public ModelAndView sharePlanView(Model model, HttpServletRequest req) {
        List<Plan> planList = shareService.getSharedPlanList();
        model.addAttribute("planList", planList);
        return new ModelAndView("sharePlan");
    }

    @GetMapping("samplePlan")
    public ModelAndView myPlanView(Model model, HttpServletRequest req) {
        model.addAttribute("planList", shareService.getAdminPlanList());
        return new ModelAndView("samplePlan");
    }
}
