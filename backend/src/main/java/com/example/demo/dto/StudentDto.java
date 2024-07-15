package com.example.demo.dto;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDto {
    private Long id;
    private String name;
    private String dong;
    private String school;
    private String major;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}
