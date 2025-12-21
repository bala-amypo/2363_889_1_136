package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FinancialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double monthlyIncome;
    private Double monthlyExpenses;
    private Double existingLoanEmi;
    private Integer creditScore;
    private Double savingsBalance;
    private LocalDateTime lastUpdatedAt;

    @PrePersist @PreUpdate
    protected void onUpdate() { this.lastUpdatedAt = LocalDateTime.now(); }

    public FinancialProfile() {}
    // Getters and Setters
}