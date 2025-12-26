package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.repository.RiskAssessmentRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final RiskAssessmentRepository repository;

    public RiskAssessmentServiceImpl(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {
        RiskAssessment risk = new RiskAssessment();
        risk.setLoanRequestId(loanRequestId);
        risk.setRiskLevel("LOW");
        return repository.save(risk);
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return repository.findByLoanRequestId(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Risk not found"));
    }
}
