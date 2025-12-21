package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    public void configure() {}
    @Bean public Object passwordEncoder() { return null; }
}