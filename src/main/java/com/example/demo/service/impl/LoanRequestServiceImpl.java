package com.example.demo.service.impl;

import com.example.demo.entity.LoanRequest;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.service.LoanRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository loanRequestRepository;

    public LoanRequestServiceImpl(LoanRequestRepository loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public LoanRequest submitLoanRequest(LoanRequest request) {

        request.setStatus(LoanRequest.Status.SUBMITTED);

        request.setSubmittedAt(LocalDateTime.now());
        return loanRequestRepository.save(request);
    }

    @Override
    public List<LoanRequest> getRequestsByUser(Long userId) {
        return loanRequestRepository.findByUserId(userId);
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return loanRequestRepository.findById(id).orElse(null);
    }
}
