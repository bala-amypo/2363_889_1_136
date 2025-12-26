package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.*;
import com.example.demo.service.RiskAssessmentService;

import java.util.Optional;

public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;
    private final RiskAssessmentRepository riskAssessmentRepository;

    public RiskAssessmentServiceImpl(
            LoanRequestRepository loanRequestRepository,
            FinancialProfileRepository financialProfileRepository,
            RiskAssessmentRepository riskAssessmentRepository) {

        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {

        if (riskAssessmentRepository.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Risk already assessed");
        }

        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new BadRequestException("Loan not found"));

        FinancialProfile fp = financialProfileRepository
                .findByUserId(loanRequest.getUser().getId())
                .orElseThrow(() -> new BadRequestException("Profile not found"));

        double income = fp.getMonthlyIncome() != null ? fp.getMonthlyIncome() : 0.0;
        double emi = fp.getExistingLoanEmi() != null ? fp.getExistingLoanEmi() : 0.0;

        double dti = income == 0 ? 0.0 : emi / income;

        RiskAssessment ra = new RiskAssessment();
        ra.setLoanRequest(loanRequest);
        ra.setDtiRatio(dti);
        ra.setRiskScore(Math.min(100.0, Math.max(0.0, dti * 100)));

        return riskAssessmentRepository.save(ra);
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return riskAssessmentRepository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new BadRequestException("Risk not found"));
    }
}
