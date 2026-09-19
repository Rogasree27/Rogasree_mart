package com.rogasree.rogasreemart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}