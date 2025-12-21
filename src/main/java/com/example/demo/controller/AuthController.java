package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // In a real impl, this would call authenticationManager.authenticate()
        // and generate a JWT using JwtUtil.
        AuthResponse response = new AuthResponse();
        User user = userService.findByEmail(request.email);
        if (user != null) {
            response.userId = user.getId();
            response.email = user.getEmail();
            response.fullName = user.getFullName();
            response.role = user.getRole();
            response.token = "dummy-jwt-token"; 
        }
        return ResponseEntity.ok(response);
    }
}