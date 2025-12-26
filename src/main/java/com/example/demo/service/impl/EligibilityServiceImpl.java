package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service  
public class EligibilityServiceImpl implements EligibilityService {

    private final EligibilityResultRepository eligibilityResultRepository;

    public EligibilityServiceImpl(EligibilityResultRepository eligibilityResultRepository) {
        this.eligibilityResultRepository = eligibilityResultRepository;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId)
                .orElse(null);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return eligibilityResultRepository.findByLoanRequestId(loanRequestId)
                .orElse(null);
    }
}
