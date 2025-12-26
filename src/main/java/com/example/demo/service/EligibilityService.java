package com.example.demo.service;

import com.example.demo.entity.Eligibility;

public interface EligibilityService {

    Eligibility getByLoanRequestId(Long loanRequestId);
}
