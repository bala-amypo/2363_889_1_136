package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {
    private final RiskAssessmentLogRepository riskRepo;
    private final FinancialProfileRepository profileRepo;

    public RiskAssessmentServiceImpl(RiskAssessmentLogRepository riskRepo, FinancialProfileRepository profileRepo) {
        this.riskRepo = riskRepo;
        this.profileRepo = profileRepo;
    }

    @Override
    public RiskAssessmentLog assessRisk(Long loanRequestId) {
        if (!riskRepo.findByLoanRequestId(loanRequestId).isEmpty()) {
            throw new BadRequestException("Risk already assessed"); [cite: 123]
        }
        
        // Logic to calculate DTI and Log
        RiskAssessmentLog log = new RiskAssessmentLog();
        log.setLoanRequestId(loanRequestId);
        // Implementation of DTI calculation logic based on Section 2.5 [cite: 102]
        return riskRepo.save(log);
    }

    @Override
    public List<RiskAssessmentLog> getByLoanRequestId(Long loanRequestId) {
        return riskRepo.findByLoanRequestId(loanRequestId);
    }
}