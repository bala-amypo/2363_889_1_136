package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;

    public EligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public EligibilityResult checkEligibility(Long loanRequestId) {

        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        FinancialProfile profile = financialProfileRepository
                .findByUserId(loanRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Financial profile not found"));

        double calculatedEmi = loanRequest.getEmi();
        double maxAllowedEmi = profile.getMonthlyIncome() * 0.4;

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setCalculatedEmi(calculatedEmi);
        result.setMaxAllowedEmi(maxAllowedEmi);
        result.setEligible(calculatedEmi <= maxAllowedEmi);

        return result;
    }
}
