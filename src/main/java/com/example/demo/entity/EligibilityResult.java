package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EligibilityResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private LoanRequest loanRequest;

    private Double maxEligibleAmount;

    public EligibilityResult() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LoanRequest getLoanRequest() { return loanRequest; }
    public void setLoanRequest(LoanRequest loanRequest) { this.loanRequest = loanRequest; }

    public Double getMaxEligibleAmount() { return maxEligibleAmount; }
    public void setMaxEligibleAmount(Double maxEligibleAmount) { this.maxEligibleAmount = maxEligibleAmount; }
}
