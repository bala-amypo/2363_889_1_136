package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;

import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repository;
    private final UserRepository userRepository;

    // REQUIRED by tests (2-arg constructor)
    public FinancialProfileServiceImpl(
            FinancialProfileRepository repository,
            UserRepository userRepository
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    // Used by tests
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return repository.save(profile);
    }

    // REQUIRED by FinancialProfileService interface
    @Override
    public FinancialProfile getProfileByUser(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }
}
