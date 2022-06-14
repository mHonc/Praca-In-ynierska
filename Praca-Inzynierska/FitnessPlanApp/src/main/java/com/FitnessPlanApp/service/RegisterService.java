package com.FitnessPlanApp.service;

import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public boolean register(String firstName, String lastName, String email, String password, String confirmPassword,
                            Model model){
        if(checkForExist(email) && confirmPassword(password, confirmPassword) && !firstName.isEmpty() && !lastName.isEmpty()
        && !email.isEmpty() && !password.isEmpty()){
            userRepository.save(new User(null, firstName, lastName, email,
                    DigestUtils.md5Hex(password).toUpperCase(), 2, null));
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Konto zostało stworzone");
            return true;
        }
        model.addAttribute("messageType", "danger");
        model.addAttribute("message", "Błąd, konto nie zostało stworzone");
        return false;
    }

    public boolean confirmPassword(String password, String password2){
        return password.equals(password2);
    }

    public boolean checkForExist(String email) {
        return !userRepository.findByEmail(email).isPresent();
    }
}
