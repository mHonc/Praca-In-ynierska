package com.FitnessPlanApp.service;

import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password, HttpServletRequest req, Model model){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(DigestUtils.md5Hex(password).toUpperCase())) {
            req.getSession().setAttribute("user", user.get());
            return true;
        }
        model.addAttribute("messageType", "danger");
        model.addAttribute("message", "Błąd, dane logowania niepoprawne");
        return false;
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email).get();
    }
}
