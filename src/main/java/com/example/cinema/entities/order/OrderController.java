package com.example.cinema.entities.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.entities.user.User;
import com.example.cinema.entities.user.UserService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orderList = orderService.findAll();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orderList = orderService.findByUserId(userId);
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDto orderBody) {
        Order newOrder = new Order(orderBody);
        User user = userService.findById(orderBody.userId());
        newOrder.setUser(user);

        orderService.create(newOrder);
        return ResponseEntity.ok(newOrder);
    }
}
