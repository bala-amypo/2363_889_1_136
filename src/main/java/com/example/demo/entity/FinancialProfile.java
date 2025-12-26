package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "financial_profiles")
public class FinancialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Link to User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 💰 Monthly income
    @Column(nullable = false)
    private double monthlyIncome;

    // 💳 Existing EMI (VERY IMPORTANT)
    @Column(nullable = false)
    private double emi;

    // 🏦 Credit score
    @Column(nullable = false)
    private int creditScore;

    // ✅ REQUIRED: Default constructor (Spring/JPA)
    public FinancialProfile() {
    }

    // Optional constructor
    public FinancialProfile(User user, double monthlyIncome, double emi, int creditScore) {
        this.user = user;
        this.monthlyIncome = monthlyIncome;
        this.emi = emi;
        this.creditScore = creditScore;
    }

    // -------------------- GETTERS & SETTERS --------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    // 🔥 THIS FIXES ALL EMI-RELATED ERRORS
    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
