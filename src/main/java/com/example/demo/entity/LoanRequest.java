package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanRequest {

    public enum Status { SUBMITTED, APPROVED, REJECTED }

    @Id
    @GeneratedValue
    private Long id;

    private double requestedAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime submittedAt;

    public double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(double v) { this.requestedAmount = v; }

    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime t) { this.submittedAt = t; }
}
