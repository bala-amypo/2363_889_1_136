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

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    // ✅ Method expected by TEST
    public User register(User user) {
        return registerUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ Method expected by TEST
    public User getById(Long id) {
        return getUserById(id);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
