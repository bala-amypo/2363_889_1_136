package com.example.demo.controller;

import com.example.demo.entity.EligibilityResult;
import com.example.demo.service.EligibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eligibility")
public class EligibilityController {

    private final EligibilityService eligibilityService;

    public EligibilityController(EligibilityService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @GetMapping("/{loanRequestId}")
    public ResponseEntity<EligibilityResult> getEligibility(
            @PathVariable Long loanRequestId) {

        return ResponseEntity.ok(
                eligibilityService.getByLoanRequestId(loanRequestId)
        );
    }
}
