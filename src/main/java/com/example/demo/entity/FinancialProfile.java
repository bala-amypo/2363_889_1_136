package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "eligibility_results")
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Loan Request reference
    @Column(nullable = false)
    private Long loanRequestId;

    // ✅ Eligible or not
    @Column(nullable = false)
    private boolean eligible;

    // 💰 Max EMI allowed
    private double maxAllowedEmi;

    // 🧮 Calculated EMI
    private double calculatedEmi;

    // Required by JPA
    public EligibilityResult() {
    }

    // ---------------- GETTERS & SETTERS ----------------

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

    public double getMaxAllowedEmi() {
        return maxAllowedEmi;
    }

    public void setMaxAllowedEmi(double maxAllowedEmi) {
        this.maxAllowedEmi = maxAllowedEmi;
    }

    public double getCalculatedEmi() {
        return calculatedEmi;
    }

    public void setCalculatedEmi(double calculatedEmi) {
        this.calculatedEmi = calculatedEmi;
    }
}
