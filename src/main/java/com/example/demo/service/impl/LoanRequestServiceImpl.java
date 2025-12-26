package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;

    public LoanRequestServiceImpl(LoanRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        request.setStatus(LoanRequest.Status.PENDING); 
        request.setSubmittedAt(LocalDateTime.now());
        return repository.save(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findByUser_Id(userId);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan request not found"));
    }
}
