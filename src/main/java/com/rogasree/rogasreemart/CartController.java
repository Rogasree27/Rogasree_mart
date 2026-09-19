package com.rogasree.rogasreemart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/cart/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    @PostMapping("/cart")
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @DeleteMapping("/cart/{id}")
    public String removeFromCart(@PathVariable Long id) {

        cartItemRepository.deleteById(id);

        return "Item removed from cart";
    }
}