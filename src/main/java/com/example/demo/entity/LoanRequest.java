package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private Integer tenure;

    private String status;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ===== GETTERS =====

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public User getUser() {
        return user;
    }

    // ===== SETTERS (THIS FIXES YOUR ERROR) =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
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
