package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {
    private final FinancialProfileRepository profileRepository;
    private final UserRepository userRepository;

    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        if (profile.getMonthlyIncome() <= 0) throw new BadRequestException("monthlyIncome must be > 0"); [cite: 86]
        if (profile.getCreditScore() < 300 || profile.getCreditScore() > 900) 
            throw new BadRequestException("creditScore must be in range 300-900"); [cite: 86, 87]
        
        return profileRepository.findByUserId(profile.getUser().getId())
            .map(existing -> {
                profile.setId(existing.getId());
                return profileRepository.save(profile);
            })
            .orElseGet(() -> profileRepository.save(profile));
    }

    @Override
    public FinancialProfile getByUserId(Long userId) {
        return profileRepository.findByUserId(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found")); [cite: 127]
    }
}