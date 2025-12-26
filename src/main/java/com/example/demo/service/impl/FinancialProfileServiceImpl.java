package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repository;

    // ✅ THIS constructor is used by SPRING
    @Autowired
    public FinancialProfileServiceImpl(FinancialProfileRepository repository) {
        this.repository = repository;
    }

    // ✅ THIS constructor is used by TEST CASES
    public FinancialProfileServiceImpl(FinancialProfileRepository repository,
                                       UserRepository userRepository) {
        this.repository = repository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        return repository.save(profile);
    }

    // ✅ test compatibility
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return createOrUpdateProfile(profile);
    }

    @Override
    public FinancialProfile getProfileByUser(Long userId) {
        return repository.findByUserId(userId).orElse(null);
    }

    // ✅ test compatibility
    public FinancialProfile getByUserId(Long userId) {
        return getProfileByUser(userId);
    }
}
