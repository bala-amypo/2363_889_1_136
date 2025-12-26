package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Override
    public EligibilityResult checkEligibility(Long loanRequestId) {
        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setEligible(true); // dummy logic
        return result;
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return checkEligibility(loanRequestId);
    }
}
