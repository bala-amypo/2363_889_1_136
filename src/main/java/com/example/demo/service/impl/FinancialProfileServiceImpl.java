package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository profileRepository;
    private final UserRepository userRepository;

    // Constructor used by Spring
    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = null;
    }

    // Constructor used by tests
    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepository,
                                       UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    // ===== Interface methods =====

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUser(Long userId) {
        return profileRepository.findByUserId(userId).orElse(null);
    }

    // ===== Test compatibility helpers =====

    public FinancialProfile createOrUpdate(FinancialProfile profile) {
        return createOrUpdateProfile(profile);
    }

    public FinancialProfile getByUserId(long userId) {
        return getProfileByUser(userId);
    }
}
