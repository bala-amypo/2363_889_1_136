package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repository;
    private final UserRepository userRepository;

    // ✅ REQUIRED BY TESTS
    public FinancialProfileServiceImpl(
            FinancialProfileRepository repository,
            UserRepository userRepository
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public FinancialProfile getByUserId(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }

    @Override
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return repository.save(profile);
    }
}
