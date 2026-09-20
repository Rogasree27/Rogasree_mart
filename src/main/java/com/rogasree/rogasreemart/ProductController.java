package com.rogasree.rogasreemart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {

        List<CartItem> cartItems =
                cartItemRepository.findAll();

        for (CartItem item : cartItems) {

            if (item.getProductId().equals(id)) {
                cartItemRepository.delete(item);
            }
        }

        List<WishlistItem> wishlistItems =
                wishlistItemRepository.findAll();

        for (WishlistItem item : wishlistItems) {

            if (item.getProductId().equals(id)) {
                wishlistItemRepository.delete(item);
            }
        }

        productRepository.deleteById(id);
    }
}