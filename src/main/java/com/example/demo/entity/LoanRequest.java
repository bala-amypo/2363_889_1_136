package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double requestedAmount;
    private Integer tenureMonths;
    private String purpose;
    private String status = "PENDING";
    private LocalDateTime appliedAt;

    @PrePersist
    protected void onCreate() { this.appliedAt = LocalDateTime.now(); }

    public LoanRequest() {}
    // Getters and Setters
}