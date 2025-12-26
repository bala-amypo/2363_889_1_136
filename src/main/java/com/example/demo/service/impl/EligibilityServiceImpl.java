package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Override
    public boolean isEligible(FinancialProfile profile, LoanRequest loanRequest) {

        if (profile == null || loanRequest == null) {
            return false;
        }

        double monthlyIncome = profile.getMonthlyIncome();

        // ✅ FIXED getter
        double existingEmi = profile.getExistingEmi();

        double loanAmount = loanRequest.getAmount();
        int tenure = loanRequest.getTenure();

        double newEmi = loanAmount / tenure;

        // Rule: EMI ≤ 50% of income
        return (existingEmi + newEmi) <= (monthlyIncome * 0.5);
    }
}
