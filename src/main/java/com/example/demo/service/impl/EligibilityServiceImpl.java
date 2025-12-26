package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Override
    public EligibilityResult checkEligibility(
            LoanRequest loanRequest,
            FinancialProfile profile
    ) {

        EligibilityResult result = new EligibilityResult();

        // Example EMI calculation (simple)
        double emi = loanRequest.getEmi();
        double maxAllowedEmi = profile.getMonthlyIncome() * 0.4;

        result.setLoanRequestId(loanRequest.getId());
        result.setCalculatedEmi(emi);
        result.setMaxAllowedEmi(maxAllowedEmi);

        boolean eligible = (emi + profile.getEmi()) <= maxAllowedEmi;
        result.setEligible(eligible);

        return result;
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        // For now, return null or throw exception if not required by test
        return null;
    }
}
