package com.FitnessPlanApp.view;

import com.FitnessPlanApp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginViewController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public ModelAndView loginView() {
        return new ModelAndView("login");
    }

    @PostMapping("login")
    public String login(String email, String password, HttpServletRequest req, Model model) {
        if (loginService.login(email, password, req, model)) {
            return "redirect:home";
        }
        return "login";
    }
}