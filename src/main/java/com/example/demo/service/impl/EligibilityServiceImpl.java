package com.example.demo.service.impl;

import com.example.demo.entity.Eligibility;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.EligibilityRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final EligibilityRepository eligibilityRepository;

    // ✅ REQUIRED constructor for Spring
    public EligibilityServiceImpl(EligibilityRepository eligibilityRepository) {
        this.eligibilityRepository = eligibilityRepository;
    }

    // ✅ FIX 1: Correctly implement interface method
    @Override
    public Eligibility getByLoanRequestId(Long loanRequestId) {
        return eligibilityRepository.findByLoanRequestId(loanRequestId)
                .orElse(null);
    }

    // ✅ Helper method (NO @Override because not in interface)
    public boolean checkEligibility(FinancialProfile profile, LoanRequest loanRequest) {

        if (profile == null || loanRequest == null) {
            return false;
        }

        double monthlyIncome = profile.getMonthlyIncome();

        // ✅ FIX 2: Use correct getter name
        double existingEmi = profile.getEmi();  

        double loanAmount = loanRequest.getAmount();
        int tenure = loanRequest.getTenure();

        double emi = loanAmount / tenure;

        return (existingEmi + emi) <= (monthlyIncome * 0.5);
    }
}
