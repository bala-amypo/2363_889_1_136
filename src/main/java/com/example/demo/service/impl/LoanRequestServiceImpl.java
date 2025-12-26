package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;
    private final UserRepository userRepository;

    public LoanRequestServiceImpl(
            LoanRequestRepository repository,
            UserRepository userRepository
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {
        return repository.save(request);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
