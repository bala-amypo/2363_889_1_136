package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;

    public EligibilityServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository
    ) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public EligibilityResult checkEligibility(Long loanRequestId) {

        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId).orElseThrow();
        FinancialProfile profile =
                financialProfileRepository.findByUserId(loanRequest.getUser().getId());

        double emi = loanRequest.getAmount() / loanRequest.getTenureMonths();
        double maxAllowedEmi = profile.getMonthlyIncome() * 0.4;

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setCalculatedEmi(emi);
        result.setMaxAllowedEmi(maxAllowedEmi);
        result.setEligible((emi + profile.getEmi()) <= maxAllowedEmi);

        return result;
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return null;
    }
}
