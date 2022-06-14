package com.FitnessPlanApp.view;

import com.FitnessPlanApp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterViewController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("register")
    public ModelAndView registerView() {
        return new ModelAndView("register");
    }

    @PostMapping("register")
    public String register(String firstName, String lastName, String email, String password, String confirmPassword,
                           Model model){
        if (registerService.register(firstName, lastName, email, password, confirmPassword, model)) {
            return "login";
        }
        return "register";
    }
}
