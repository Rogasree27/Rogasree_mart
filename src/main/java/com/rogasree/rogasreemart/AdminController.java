package com.rogasree.rogasreemart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin/login")
    public Admin adminLogin(@RequestBody Admin admin) {

        return adminRepository.findByEmailAndPassword(
                admin.getEmail(),
                admin.getPassword()
        ).orElse(null);
    }
}