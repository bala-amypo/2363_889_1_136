package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {
    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository resultRepo;

    public LoanEligibilityServiceImpl(LoanRequestRepository l, FinancialProfileRepository p, EligibilityResultRepository r) {
        this.loanRepo = l; this.profileRepo = p; this.resultRepo = r;
    }

    @Override
    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        if (resultRepo.findByLoanRequestId(loanRequestId).isPresent()) {
            throw new BadRequestException("Eligibility already evaluated"); [cite: 122]
        }
        LoanRequest req = loanRepo.findById(loanRequestId)
            .orElseThrow(() -> new ResourceNotFoundException("Loan request not found")); [cite: 128]
        FinancialProfile prof = profileRepo.findByUserId(req.getUser().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found")); [cite: 127]

        EligibilityResult res = new EligibilityResult();
        res.setLoanRequest(req);
        
        double totalObligations = prof.getMonthlyExpenses() + (prof.getExistingLoanEmi() != null ? prof.getExistingLoanEmi() : 0);
        double dti = totalObligations / prof.getMonthlyIncome();

        if (prof.getCreditScore() < 600 || dti > 0.4) {
            res.setIsEligible(false);
            res.setRiskLevel("HIGH");
            res.setRejectionReason("High DTI or Low Credit Score");
            res.setMaxEligibleAmount(0.0);
            res.setEstimatedEmi(0.0);
        } else {
            res.setIsEligible(true);
            res.setRiskLevel(prof.getCreditScore() > 750 ? "LOW" : "MEDIUM");
            res.setMaxEligibleAmount(prof.getMonthlyIncome() * 5);
            res.setEstimatedEmi((res.getMaxEligibleAmount() / req.getTenureMonths()) * 1.1);
        }
        return resultRepo.save(res);
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long id) {
        return resultRepo.findByLoanRequestId(id).orElseThrow(() -> new ResourceNotFoundException("Eligibility result not found")); [cite: 129]
    }
}