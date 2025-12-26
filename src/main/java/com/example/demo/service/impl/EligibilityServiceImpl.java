package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.repository.EligibilityResultRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final EligibilityResultRepository repository;

    public EligibilityServiceImpl(EligibilityResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {
        return repository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Eligibility not found"));
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setEligible(true);
        result.setMaxEligibleAmount(500000.0);
        return repository.save(result);
    }
}
