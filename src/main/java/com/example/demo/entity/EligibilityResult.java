package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanRequestId;
    private boolean eligible;
    private double calculatedEmi;
    private double maxAllowedEmi;

    public Long getId() {
        return id;
    }

    public Long getLoanRequestId() {
        return loanRequestId;
    }

    public void setLoanRequestId(Long loanRequestId) {
        this.loanRequestId = loanRequestId;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public double getCalculatedEmi() {
        return calculatedEmi;
    }

    public void setCalculatedEmi(double calculatedEmi) {
        this.calculatedEmi = calculatedEmi;
    }

    public double getMaxAllowedEmi() {
        return maxAllowedEmi;
    }

    public void setMaxAllowedEmi(double maxAllowedEmi) {
        this.maxAllowedEmi = maxAllowedEmi;
    }
}
