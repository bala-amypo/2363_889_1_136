package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EligibilityResult {

    @Id
    @GeneratedValue
    private Long id;

    private Long loanRequestId;
    private boolean eligible;
    private double maxEligibleAmount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long id) { this.loanRequestId = id; }

    public boolean isEligible() { return eligible; }
    public void setEligible(boolean e) { this.eligible = e; }

    public double getMaxEligibleAmount() { return maxEligibleAmount; }
    public void setMaxEligibleAmount(double v) { this.maxEligibleAmount = v; }
}
