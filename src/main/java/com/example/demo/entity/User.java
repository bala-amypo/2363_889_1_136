package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role = "CUSTOMER";
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    public User() {}
    public User(Long id, String fullName, String email, String password, String role) {
        this.id = id; this.fullName = fullName; this.email = email; this.password = password; this.role = role;
    }
    // Getters and Setters omitted for brevity
}