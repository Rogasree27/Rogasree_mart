package com.rogasree.rogasreemart;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/forgot-password")
    public String resetPassword(@RequestBody Map<String, String> request) {

        String email = request.get("email");
        String newPassword = request.get("newPassword");

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            return "Email not found";
        }

        user.setPassword(newPassword);
        userRepository.save(user);

        return "Password updated successfully";
    }
}