package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Override
    public boolean checkEligibility(FinancialProfile profile, LoanRequest loanRequest) {

        if (profile == null || loanRequest == null) {
            return false;
        }

        double monthlyIncome = profile.getMonthlyIncome();
        double existingEmi = profile.getExistingEmi();
        double loanAmount = loanRequest.getAmount();

        // ✅ FIXED HERE (was getTenureMonths())
        int tenureMonths = loanRequest.getTenure();

        // Simple EMI calculation
        double emi = loanAmount / tenureMonths;

        // Eligibility rule: EMI should not exceed 50% of income
        return (existingEmi + emi) <= (monthlyIncome * 0.5);
    }
}
