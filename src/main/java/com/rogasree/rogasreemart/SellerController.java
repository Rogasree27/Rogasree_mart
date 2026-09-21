package com.rogasree.rogasreemart;

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
        if (seller == null || seller.getEmail() == null || seller.getPassword() == null) {
            return null;
        }
        return sellerRepository.findByEmailAndPassword(
                seller.getEmail(),
                seller.getPassword()
        ).orElse(null);
    }
}