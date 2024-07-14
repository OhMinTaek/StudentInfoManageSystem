package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "StudentName")
public class StudentName {

    @Id
    private Long id;
    private String name;

    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
