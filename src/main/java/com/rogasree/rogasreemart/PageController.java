package com.rogasree.rogasreemart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/buyer-login")
    public String buyerLogin() {
        return "forward:/login.html";
    }

    @GetMapping("/seller-login")
    public String sellerLogin() {
        return "forward:/seller-login.html";
    }

    @GetMapping("/admin-login")
    public String adminLogin() {
        return "forward:/admin-login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "forward:/register.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "forward:/cart.html";
    }

    @GetMapping("/wishlist")
    public String wishlist() {
        return "forward:/wishlist.html";
    }

    @GetMapping("/home")
    public String home() {
        return "forward:/home.html";
    }
}