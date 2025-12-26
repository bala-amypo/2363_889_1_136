package com.example.demo.service;

import com.example.demo.entity.LoanRequest;

import java.util.List;

public interface LoanRequestService {

    LoanRequest submitRequest(LoanRequest request);

    LoanRequest getRequestById(Long id);

    List<LoanRequest> getAllRequests();
}
