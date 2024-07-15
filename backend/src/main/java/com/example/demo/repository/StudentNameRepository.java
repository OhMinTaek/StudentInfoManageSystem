package com.example.demo.repository;

import com.example.demo.entity.StudentName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// StudentNameRepository.java
public interface StudentNameRepository extends JpaRepository<StudentName, Long> {
    List<StudentName> findAllByOrderByName();
}