package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;

    public RiskAssessmentServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository
    ) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public String assessRisk(Long loanRequestId) {

        LoanRequest request = loanRequestRepository.findById(loanRequestId).orElseThrow();
        FinancialProfile fp =
                financialProfileRepository.findByUserId(request.getUser().getId());

        if (fp.getCreditScore() >= 750) return "LOW";
        if (fp.getCreditScore() >= 600) return "MEDIUM";
        return "HIGH";
    }

    @Override
    public String getByLoanRequestId(Long loanRequestId) {
        return assessRisk(loanRequestId);
    }
}
