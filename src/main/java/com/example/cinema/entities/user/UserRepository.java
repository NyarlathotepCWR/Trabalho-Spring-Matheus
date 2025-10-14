package com.example.cinema.entities.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    User findByCpf(String cpf);

    Optional<User> findByEmail(String email);
}
