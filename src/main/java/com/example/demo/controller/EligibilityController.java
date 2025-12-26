package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.EligibilityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eligibility")
public class EligibilityController {

    private final EligibilityService eligibilityService;

    // Spring injects EligibilityServiceImpl here
    public EligibilityController(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @GetMapping("/{loanRequestId}")
    public EligibilityResult getEligibility(@PathVariable Long loanRequestId) {
        return eligibilityService.getByLoanRequestId(loanRequestId);
    }
}
