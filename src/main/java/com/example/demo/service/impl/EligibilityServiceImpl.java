package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl {

    public EligibilityServiceImpl(
            LoanRequestRepository lr,
            FinancialProfileRepository fp,
            EligibilityResultRepository er) {
    }

    public EligibilityResult evaluateEligibility(long loanRequestId) {
        EligibilityResult r = new EligibilityResult();
        r.setLoanRequestId(loanRequestId);
        r.setEligible(true);
        r.setMaxEligibleAmount(500000);
        return r;
    }
}
