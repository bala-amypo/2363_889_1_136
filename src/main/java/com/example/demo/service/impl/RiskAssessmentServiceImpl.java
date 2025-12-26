package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final FinancialProfileRepository financialProfileRepository;

    public RiskAssessmentServiceImpl(FinancialProfileRepository financialProfileRepository) {
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public String assessRisk(Long userId) {

        FinancialProfile profile = financialProfileRepository
                .findByUser_Id(userId)   // ✅ FIXED HERE
                .orElseThrow(() ->
                        new RuntimeException("Financial profile not found"));

        if (profile.getCreditScore() >= 750) return "LOW";
        if (profile.getCreditScore() >= 650) return "MEDIUM";
        return "HIGH";
    }
}
