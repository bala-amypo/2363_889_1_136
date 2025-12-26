package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    // REQUIRED BY TEST
    public User register(User user) {
        return repository.save(user);
    }

    // REQUIRED BY TEST
    public User getById(long id) {
        return repository.findById(id).orElse(null);
    }

    // REQUIRED BY INTERFACE
    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
