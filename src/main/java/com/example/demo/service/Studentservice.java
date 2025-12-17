package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Studententity;

public interface StudentService {
    Student insertStudent(Studententity st);
    List<Student> getAllStudents();
    Optional<Student> getOneStudent(Long id);
    void deleteStudent(Long id);
}