package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repository;
    private final UserRepository userRepository;

    // REQUIRED BY TEST
    public LoanRequestServiceImpl(LoanRequestRepository repository,
                                  UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    // REQUIRED BY TEST
    public LoanRequest submitRequest(LoanRequest request) {
        request.setSubmittedAt(LocalDateTime.now());
        return repository.save(request);
    }

    // REQUIRED BY TEST
    public LoanRequest getById(long id) {
        return repository.findById(id).orElse(null);
    }
}
