package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;

    public RiskAssessmentServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {

        LoanRequest request = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        FinancialProfile fp = financialProfileRepository
                .findByUserId(request.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Financial profile not found"));

        RiskAssessment risk = new RiskAssessment();
        risk.setLoanRequestId(loanRequestId);

        if (fp.getCreditScore() >= 750) {
            risk.setRiskLevel("LOW");
        } else if (fp.getCreditScore() >= 600) {
            risk.setRiskLevel("MEDIUM");
        } else {
            risk.setRiskLevel("HIGH");
        }

        return risk;
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return assessRisk(loanRequestId);
    }
}
