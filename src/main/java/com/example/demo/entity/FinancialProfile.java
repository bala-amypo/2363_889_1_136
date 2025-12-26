package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FinancialProfile {

    @Id
    @GeneratedValue
    private Long id;

    private double monthlyExpenses;
    private double existingLoanEmi;
    private double savingsBalance;
    private int creditScore;

    private LocalDateTime lastUpdatedAt;

    public double getMonthlyExpenses() { return monthlyExpenses; }
    public void setMonthlyExpenses(double v) { this.monthlyExpenses = v; }

    public double getExistingLoanEmi() { return existingLoanEmi; }
    public void setExistingLoanEmi(double v) { this.existingLoanEmi = v; }

    public double getSavingsBalance() { return savingsBalance; }
    public void setSavingsBalance(double v) { this.savingsBalance = v; }

    public int getCreditScore() { return creditScore; }
    public void setCreditScore(int v) { this.creditScore = v; }

    public LocalDateTime getLastUpdatedAt() { return lastUpdatedAt; }
    public void setLastUpdatedAt(LocalDateTime t) { this.lastUpdatedAt = t; }
}
