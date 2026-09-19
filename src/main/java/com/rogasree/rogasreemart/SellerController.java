package com.rogasree.rogasreemart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}