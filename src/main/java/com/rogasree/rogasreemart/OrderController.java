package com.rogasree.rogasreemart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @GetMapping("/orders/all")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {

        if (order.getStatus() == null ||
            order.getStatus().isEmpty()) {

            order.setStatus("Pending");
        }

        return orderRepository.save(order);
    }

    @PutMapping("/orders/{id}/status")
    public Order updateOrderStatus(
            @PathVariable Long id,
            @RequestBody Order orderData) {

        Order order =
                orderRepository.findById(id).orElse(null);

        if (order == null) {
            return null;
        }

        order.setStatus(orderData.getStatus());

        return orderRepository.save(order);
    }
}