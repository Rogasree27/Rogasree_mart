package com.rogasree.rogasreemart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmailAndPassword(
            String email,
            String password
    );

    Optional<Admin> findByEmail(String email);
}