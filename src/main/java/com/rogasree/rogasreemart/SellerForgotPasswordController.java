package com.rogasree.rogasreemart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SellerForgotPasswordController {

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping("/seller/forgot-password")
    public String resetSellerPassword(
            @RequestBody Map<String, String> request) {

        String email = request.get("email");
        String newPassword = request.get("newPassword");

        Seller seller =
                sellerRepository.findByEmail(email)
                        .orElse(null);

        if (seller == null) {
            return "Email not found";
        }

        seller.setPassword(newPassword);

        sellerRepository.save(seller);

        return "Password updated successfully";
    }
}