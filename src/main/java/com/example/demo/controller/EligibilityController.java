package com.example.demo.controller;
import com.example.demo.service.LoanEligibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {
    private final LoanEligibilityService service;
    public EligibilityController(LoanEligibilityService s) { this.service = s; }

    @PostMapping("/evaluate/{loanRequestId}")
    public ResponseEntity<?> evaluate(@PathVariable Long loanRequestId) {
        return ResponseEntity.ok(service.evaluateEligibility(loanRequestId));
    }

    @GetMapping("/result/{loanRequestId}")
    public ResponseEntity<?> getResult(@PathVariable Long loanRequestId) {
        return ResponseEntity.ok(service.getByLoanRequestId(loanRequestId));
    }
}