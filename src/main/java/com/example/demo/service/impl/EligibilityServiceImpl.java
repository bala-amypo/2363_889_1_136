package com.example.demo.service.impl;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.EligibilityService;
import org.springframework.stereotype.Service;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    private final LoanRequestRepository loanRequestRepository;
    private final FinancialProfileRepository financialProfileRepository;

    public EligibilityServiceImpl(LoanRequestRepository loanRequestRepository,
                                  FinancialProfileRepository financialProfileRepository) {
        this.loanRequestRepository = loanRequestRepository;
        this.financialProfileRepository = financialProfileRepository;
    }

    @Override
    public EligibilityResult getByLoanRequestId(Long loanRequestId) {

        LoanRequest loanRequest = loanRequestRepository.findById(loanRequestId)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));

        FinancialProfile profile = financialProfileRepository
                .findByUserId(loanRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Financial profile not found"));

        double income = profile.getMonthlyIncome();
        double existingEmi = profile.getEmi();   // ✅ FIXED (see Error 2)
        double newEmi = loanRequest.getAmount() / loanRequest.getTenure();

        boolean eligible = (existingEmi + newEmi) <= (income * 0.5);

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequestId(loanRequestId);
        result.setEligible(eligible);

        return result;
    }
}
