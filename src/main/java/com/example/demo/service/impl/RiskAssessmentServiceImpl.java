package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final RiskAssessmentLogRepository riskRepo;
    private final FinancialProfileRepository profileRepo;

    public RiskAssessmentServiceImpl(RiskAssessmentLogRepository riskRepo,
                                     FinancialProfileRepository profileRepo) {
        this.riskRepo = riskRepo;
        this.profileRepo = profileRepo;
    }

    @Override
    public RiskAssessmentLog assessRisk(Long loanRequestId, Long financialProfileId) {

        // Prevent duplicate risk assessment
        if (!riskRepo.findByLoanRequestId(loanRequestId).isEmpty()) {
            throw new BadRequestException("Risk already assessed for this loan request");
        }

        FinancialProfile profile = profileRepo.findById(financialProfileId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Financial profile not found"));

        // Calculate Debt-To-Income (DTI) ratio
        double monthlyIncome = profile.getAnnualIncome() / 12.0;
        double dti = profile.getMonthlyLiabilities() / monthlyIncome;

        String riskLevel;
        if (dti < 0.30 && profile.getCreditScore() >= 750) {
            riskLevel = "LOW";
        } else if (dti < 0.45 && profile.getCreditScore() >= 650) {
            riskLevel = "MEDIUM";
        } else {
            riskLevel = "HIGH";
        }

        RiskAssessmentLog log = new RiskAssessmentLog();
        log.setLoanRequestId(loanRequestId);
        log.setRiskLevel(riskLevel);
        log.setDtiRatio(dti);
        log.setAssessedAt(LocalDateTime.now());

        return riskRepo.save(log);
    }

    @Override
    public List<RiskAssessmentLog> getByLoanRequestId(Long loanRequestId) {
        return riskRepo.findByLoanRequestId(loanRequestId);
    }

    @Override
    public List<RiskAssessmentLog> getAllAssessments() {
        return riskRepo.findAll();
    }
}
