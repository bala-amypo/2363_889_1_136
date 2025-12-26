package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    @Override
    public String assessRisk(FinancialProfile fp, LoanRequest request) {

        double income = fp.getMonthlyIncome();
        double existingEmi = fp.getEmi();   // ✅ FIXED
        double newEmi = request.getEmi();

        double emiRatio = (existingEmi + newEmi) / income;

        if (fp.getCreditScore() < 600 || emiRatio > 0.6) {
            return "HIGH_RISK";
        }

        if (fp.getCreditScore() < 700 || emiRatio > 0.4) {
            return "MEDIUM_RISK";
        }

        return "LOW_RISK";
    }
}
