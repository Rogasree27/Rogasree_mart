package com.rogasree.rogasreemart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findByEmailAndPassword(
            String email,
            String password
    );

    Optional<Seller> findByEmail(String email);
}