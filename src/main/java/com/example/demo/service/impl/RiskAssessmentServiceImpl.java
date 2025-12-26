package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl {

    public RiskAssessmentServiceImpl(
            LoanRequestRepository lr,
            FinancialProfileRepository fp,
            RiskAssessmentRepository rr) {
    }

    public RiskAssessment assessRisk(long loanRequestId) {
        RiskAssessment r = new RiskAssessment();
        r.setLoanRequestId(loanRequestId);
        r.setRiskScore(0.3);
        r.setDtiRatio(0.4);
        r.setRiskLevel("LOW");
        return r;
    }

    public RiskAssessment getByLoanRequestId(long id) {
        return assessRisk(id);
    }
}
