package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;

import org.springframework.stereotype.Service;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;
    private final UserRepository userRepository;

    // REQUIRED by tests (2-arg constructor)
    public LoanRequestServiceImpl(
            LoanRequestRepository repository,
            UserRepository userRepository
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    // Used by tests
    public LoanRequest submitRequest(LoanRequest request) {
        return repository.save(request);
    }

    // REQUIRED by LoanRequestService interface
    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
