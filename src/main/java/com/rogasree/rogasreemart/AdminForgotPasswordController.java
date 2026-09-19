package com.rogasree.rogasreemart;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminForgotPasswordController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin/forgot-password")
    public String resetAdminPassword(
            @RequestBody Map<String, String> request) {

        String email = request.get("email");
        String newPassword = request.get("newPassword");

        Admin admin =
                adminRepository.findByEmail(email)
                        .orElse(null);

        if (admin == null) {
            return "Email not found";
        }

        admin.setPassword(newPassword);

        adminRepository.save(admin);

        return "Password updated successfully";
    }
}