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
public class WishlistController {

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @GetMapping("/wishlist/{userId}")
    public List<WishlistItem> getWishlist(@PathVariable Long userId) {
        return wishlistItemRepository.findByUserId(userId);
    }

    @PostMapping("/wishlist")
    public WishlistItem addToWishlist(
            @RequestBody WishlistItem wishlistItem) {

        return wishlistItemRepository.save(wishlistItem);
    }

    @DeleteMapping("/wishlist/{id}")
    public String removeFromWishlist(@PathVariable Long id) {

        wishlistItemRepository.deleteById(id);

        return "Item removed from wishlist";
    }
}