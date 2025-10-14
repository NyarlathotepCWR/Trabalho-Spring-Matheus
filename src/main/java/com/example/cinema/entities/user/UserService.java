package com.example.cinema.entities.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.infra.exceptions.ConflictExceptions;
import com.example.cinema.infra.exceptions.NotFoundExceptions;
import com.example.cinema.infra.exceptions.UnauthorizedExceptions;
import com.example.cinema.utils.PasswordUtils;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundExceptions.UserNotFound(id));
    }

    public User createUser(User user) {
        validateUser(user);
        user.setPassword(PasswordUtils.encriptPassword(user.getPassword()));
        return repository.save(user);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundExceptions.UserNotFound(email));
    }

    public boolean validatePassword(String password, String encodedPassword) {
        if (!PasswordUtils.validatePassword(password, encodedPassword)) {
            throw new UnauthorizedExceptions.InvalidPassword();
        }
        return true;
    }

    // Centraliza o tratamento de todas as exceções de usuario
    private void validateUser(User user) {
        if (repository.existsByCpf(user.getCpf())) {
            throw new ConflictExceptions.DuplicateCpf("This CPF already exists");
        }
        if (repository.existsByEmail(user.getEmail())) {
            throw new ConflictExceptions.DuplicateEmail("This email already exists");
        }
    }
}
