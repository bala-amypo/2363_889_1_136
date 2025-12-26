package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;

    // ✅ Constructor used by SPRING
    @Autowired
    public LoanRequestServiceImpl(LoanRequestRepository repository) {
        this.repository = repository;
    }

    // ✅ Constructor used by TEST CASES
    public LoanRequestServiceImpl(LoanRequestRepository repository,
                                  UserRepository userRepository) {
        this.repository = repository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        request.setStatus("SUBMITTED");
        request.setSubmittedAt(LocalDateTime.now());
        return repository.save(request);
    }

    // ✅ test compatibility
    public LoanRequest submitRequest(LoanRequest request) {
        return submitLoanRequest(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ test compatibility
    public LoanRequest getById(Long id) {
        return getRequestById(id);
    }
}
