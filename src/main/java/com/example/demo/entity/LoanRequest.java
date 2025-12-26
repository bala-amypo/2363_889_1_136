package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_requests")
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private int tenureMonths;

    private String status;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ---------- REQUIRED GETTERS ----------

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public User getUser() {
        return user;
    }

    // EMI calculation used in services
    public double getEmi() {
        return amount / tenureMonths;
    }

    // ---------- SETTERS ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
