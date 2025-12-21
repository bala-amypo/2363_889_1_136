package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.service.FinancialProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repo;

    public FinancialProfileServiceImpl(FinancialProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public FinancialProfile create(FinancialProfile profile) {
        return repo.save(profile);
    }

    @Override
    public FinancialProfile getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));
    }

    @Override
    public List<FinancialProfile> getAll() {
        return repo.findAll();
    }

    @Override
    public FinancialProfile update(Long id, FinancialProfile updated) {
        FinancialProfile existing = getById(id);

        existing.setAnnualIncome(updated.getAnnualIncome());
        existing.setMonthlyLiabilities(updated.getMonthlyLiabilities());
        existing.setCreditScore(updated.getCreditScore());

        return repo.save(existing);
    }
}
