package com.rogasree.rogasreemart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Admin Login
    @PostMapping("/admin/login")
    public Admin adminLogin(@RequestBody Admin admin) {
        return adminRepository.findByEmailAndPassword(
                admin.getEmail(),
                admin.getPassword()
        ).orElse(null);
    }

    // Admin Register
    @PostMapping("/admin/register")
    public String adminRegister(@RequestBody Admin admin) {
        // Check if email already exists using Optional
        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            return "Email already registered!";
        }
        adminRepository.save(admin);
        return "Registration successful";
    }

    // Admin Forgot Password
    @PostMapping("/admin/forgot-password")
    public String forgotPassword(@RequestBody Admin admin) {
        Admin existing = adminRepository.findByEmail(admin.getEmail()).orElse(null);
        if (existing == null) {
            return "Email not found!";
        }
        existing.setPassword(admin.getPassword());
        adminRepository.save(existing);
        return "Password updated successfully";
    }
}