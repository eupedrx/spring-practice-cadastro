package com.example.estudospring.controller;


import com.example.estudospring.domain.User;
import com.example.estudospring.security.JwtUtil;
import com.example.estudospring.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = userService.registerUser(request.get("name"), request.get("password"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<User> user = userService.findByName(request.get("name"));
        if (user.isPresent() && user.get().getPassword().equals(request.get("password"))) {
            String token = JwtUtil.generateToken(user.get().getName());
            return ResponseEntity.ok(Map.of("token", token));
        }
        else {
            return ResponseEntity.status(401).body("Credenciais Invalidas");
        }
    }



}
