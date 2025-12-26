package com.example.demo.service.impl;

import com.example.demo.entity.RiskAssessment;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    @Override
    public RiskAssessment assessRisk(Long loanRequestId) {
        RiskAssessment risk = new RiskAssessment();
        risk.setLoanRequestId(loanRequestId);
        risk.setRiskLevel("LOW");
        return risk;
    }

    @Override
    public RiskAssessment getByLoanRequestId(Long loanRequestId) {
        return assessRisk(loanRequestId);
    }
}
