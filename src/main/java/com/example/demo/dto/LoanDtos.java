package com.example.demo.dto;

import java.time.LocalDateTime;

public class LoanDtos {

    public static class LoanRequestDto {
        public Long id;
        public Long userId;
        public Double requestedAmount;
        public Integer tenureMonths;
        public String purpose;
        public String status;
        public LocalDateTime appliedAt;
    }

    public static class FinancialProfileDto {
        public Long id;
        public Long userId;
        public Double monthlyIncome;
        public Double monthlyExpenses;
        public Double existingLoanEmi;
        public Integer creditScore;
        public Double savingsBalance;
        public LocalDateTime lastUpdatedAt;
    }
}