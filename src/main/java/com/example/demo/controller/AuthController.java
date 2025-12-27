package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          UserRepository userRepository) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    UserDetails userDetails =
            userDetailsService.loadUserByUsername(request.getEmail());

    String token = jwtUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthResponse(token));
}
