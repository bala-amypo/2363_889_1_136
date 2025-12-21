package com.example.demo.service;

import com.example.demo.entity.LoanRequest;
import java.util.List;

public interface LoanRequestService {
    LoanRequest applyForLoan(LoanRequest loanRequest);
    List<LoanRequest> getRequestsByUserId(Long userId);
    LoanRequest getById(Long id);
    List<LoanRequest> getAllPendingRequests();
    LoanRequest updateStatus(Long id, String status);
}