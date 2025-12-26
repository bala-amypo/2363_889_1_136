package com.example.demo.service;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;

public interface EligibilityService {

    boolean isEligible(FinancialProfile profile, LoanRequest loanRequest);
}
