package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "financial_profiles")
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monthlyIncome;

    private double emi;   // existing EMI

    private int creditScore;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ---------- REQUIRED GETTERS ----------

    public Long getId() {
        return id;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getEmi() {
        return emi;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public User getUser() {
        return user;
    }

    // ---------- SETTERS ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
