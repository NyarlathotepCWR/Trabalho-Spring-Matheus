package com.example.cinema.entities.order;

import com.example.cinema.entities.user.User;
import com.example.cinema.utils.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Order(OrderRequestDto data) {
        this.totalPrice = data.totalPrice();
        this.status = OrderStatus.PENDING;
    }
}
