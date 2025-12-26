package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repository;

    public FinancialProfileServiceImpl(FinancialProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {

        Long userId = profile.getUser().getId();

        Optional<FinancialProfile> existing =
                repository.findByUser_Id(userId);

        if (existing.isPresent()) {
            FinancialProfile fp = existing.get();
            fp.setMonthlyIncome(profile.getMonthlyIncome());
            fp.setMonthlyExpenses(profile.getMonthlyExpenses());
            fp.setExistingLoanEmi(profile.getExistingLoanEmi());
            fp.setSavingsBalance(profile.getSavingsBalance());
            fp.setLastUpdatedAt(LocalDateTime.now());
            return repository.save(fp);
        }

        profile.setLastUpdatedAt(LocalDateTime.now());
        return repository.save(profile);
    }

    @Override
    public FinancialProfile getProfileByUser(Long userId) {
        return repository.findByUser_Id(userId)
                .orElseThrow(() -> new RuntimeException("Financial profile not found"));
    }
}
