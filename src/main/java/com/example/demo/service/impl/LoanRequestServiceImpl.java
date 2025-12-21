package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {
    private final LoanRequestRepository loanRepo;
    private final UserRepository userRepo;

    public LoanRequestServiceImpl(LoanRequestRepository loanRepo, UserRepository userRepo) {
        this.loanRepo = loanRepo;
        this.userRepo = userRepo;
    }

    @Override
    public LoanRequest applyForLoan(LoanRequest loanRequest) {
        if (!userRepo.existsById(loanRequest.getUser().getId())) {
            throw new ResourceNotFoundException("User not found");
        }
        loanRequest.setStatus("PENDING");
        return loanRepo.save(loanRequest);
    }

    @Override
    public List<LoanRequest> getRequestsByUserId(Long userId) {
        return loanRepo.findByUserId(userId);
    }

    @Override
    public LoanRequest getById(Long id) {
        return loanRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));
    }

    @Override
    public List<LoanRequest> getAllPendingRequests() {
        return loanRepo.findByStatus("PENDING");
    }

    @Override
    public LoanRequest updateStatus(Long id, String status) {
        LoanRequest req = getById(id);
        req.setStatus(status);
        return loanRepo.save(req);
    }
}