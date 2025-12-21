package com.example.demo.service.impl;

import com.example.demo.entity.LoanEligibility;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanEligibilityRepository;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanEligibilityRepository eligibilityRepo;
    private final FinancialProfileRepository profileRepo;

    public LoanEligibilityServiceImpl(
            LoanEligibilityRepository eligibilityRepo,
            FinancialProfileRepository profileRepo) {
        this.eligibilityRepo = eligibilityRepo;
        this.profileRepo = profileRepo;
    }

    @Override
    public LoanEligibility evaluate(Long profileId) {

        FinancialProfile profile = profileRepo.findById(profileId)
                .orElseThrow(() -> new BadRequestException("Financial profile not found"));

        LoanEligibility eligibility = new LoanEligibility();
        eligibility.setProfileId(profileId);

        // Simple eligibility logic
        if (profile.getCreditScore() >= 650 && profile.getAnnualIncome() >= 300000) {
            eligibility.setEligible(true);
            eligibility.setMaxLoanAmount(10_00_000.0);
        } else {
            eligibility.setEligible(false);
            eligibility.setMaxLoanAmount(0.0);
        }

        return eligibilityRepo.save(eligibility);
    }
}
