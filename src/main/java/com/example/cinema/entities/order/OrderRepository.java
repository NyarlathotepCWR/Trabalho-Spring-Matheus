package com.example.cinema.entities.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.utils.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    List<Order> findByStatus(OrderStatus status);
}
