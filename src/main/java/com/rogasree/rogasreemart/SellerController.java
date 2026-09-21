package com.rogasree.rogasreemart;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping("/seller/login")
    public Seller sellerLogin(@RequestBody Seller seller) {

        return sellerRepository.findByEmailAndPassword(
                seller.getEmail(),
                seller.getPassword()
        ).orElse(null);
    }

    @PostMapping("/seller/forgot-password")
    public String forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String newPassword = request.get("newPassword");

        Seller seller = sellerRepository.findByEmail(email).orElse(null);
        if (seller != null) {
            seller.setPassword(newPassword);
            sellerRepository.save(seller);
            return "Password updated successfully";
        } else {
            return "Seller email not found";
        }
    }
}