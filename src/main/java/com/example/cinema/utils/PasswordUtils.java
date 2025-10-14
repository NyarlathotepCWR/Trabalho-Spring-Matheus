package com.example.cinema.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encriptPassword(String password) {
        return encoder.encode(password);
    }

    public static boolean validatePassword(String password, String encodedPassword) {
        return encoder.matches(password, encodedPassword);
    }
}
