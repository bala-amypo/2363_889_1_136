package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    // Used by tests
    public User register(User user) {
        return repository.save(user);
    }

    // Used by tests
    public User getById(long id) {
        return repository.findById(id).orElse(null);
    }

    // REQUIRED by UserService interface
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
