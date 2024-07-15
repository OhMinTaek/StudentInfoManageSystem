package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public List<StudentDto> searchStudents(@RequestParam String name) {
        return studentService.searchStudentsByName(name);
    }

    @GetMapping("/names")
    public List<StudentDto> getAllStudentNames() {
        return studentService.getAllStudentNames();
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDetails) {
        Optional<StudentDto> studentOptional = studentService.getStudentById(id);
        if (!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        studentDetails.setId(id);
        StudentDto updatedStudent = studentService.saveStudent(studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
