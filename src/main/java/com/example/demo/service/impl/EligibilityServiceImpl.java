package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final FinancialProfileRepository financialProfileRepository;

    public EligibilityServiceImpl(FinancialProfileRepository financialProfileRepository) {
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public boolean checkEligibility(Long userId) {

        FinancialProfile profile = financialProfileRepository
                .findByUser_Id(userId)   // ✅ FIXED HERE
                .orElseThrow(() ->
                        new RuntimeException("Financial profile not found"));

        return profile.getMonthlyIncome() > 30000;
    }
}
