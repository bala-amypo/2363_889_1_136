package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class RiskAssessment {

    @Id
    @GeneratedValue
    private Long id;

    private Long loanRequestId;
    private double riskScore;
    private double dtiRatio;
    private String riskLevel;

    public double getRiskScore() { return riskScore; }
    public void setRiskScore(double v) { this.riskScore = v; }

    public double getDtiRatio() { return dtiRatio; }
    public void setDtiRatio(double v) { this.dtiRatio = v; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String v) { this.riskLevel = v; }

    public Long getLoanRequestId() { return loanRequestId; }
    public void setLoanRequestId(Long id) { this.loanRequestId = id; }
}
