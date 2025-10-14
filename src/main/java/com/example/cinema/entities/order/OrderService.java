package com.example.cinema.entities.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.infra.exceptions.NotFoundExceptions;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundExceptions.OrderNotFound(id));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
