package com.example.demo.controller;

import com.example.demo.entity.LoanRequest;
import com.example.demo.service.LoanRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanRequestController {
    private final LoanRequestService service;

    public LoanRequestController(LoanRequestService service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public ResponseEntity<LoanRequest> apply(@RequestBody LoanRequest request) {
        return ResponseEntity.ok(service.applyForLoan(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanRequest>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getRequestsByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanRequest> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}