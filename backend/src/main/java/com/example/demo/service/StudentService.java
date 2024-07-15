package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentName;
import com.example.demo.repository.StudentNameRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentNameRepository studentNameRepository;

    public List<StudentDto> searchStudentsByName(String name) {
        List<Student> students = studentRepository.findByNameContainingOrderByName(name);
        return students.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<StudentDto> getAllStudentNames() {
        List<StudentName> studentNames = studentNameRepository.findAllByOrderByName();
        return studentNames.stream().map(sn -> convertToDto(sn.getStudent())).collect(Collectors.toList());
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = convertToEntity(studentDto);
        Student savedStudent = studentRepository.save(student);
        StudentName studentName = new StudentName();
        studentName.setId(savedStudent.getId());
        studentName.setName(savedStudent.getName());
        studentNameRepository.save(studentName);
        return convertToDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        studentNameRepository.deleteById(id);
        studentRepository.deleteById(id);
    }

    public Optional<StudentDto> getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(this::convertToDto);
    }

    private StudentDto convertToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setDong(student.getDong());
        studentDto.setSchool(student.getSchool());
        studentDto.setMajor(student.getMajor());
        return studentDto;
    }

    private Student convertToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setDong(studentDto.getDong());
        student.setSchool(studentDto.getSchool());
        student.setMajor(studentDto.getMajor());
        return student;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::convertToDto).collect(Collectors.toList());
    }

//    public void deleteStudent(Long id) {
//        if (studentRepository.existsById(id)) {
//            studentNameRepository.deleteById(id);
//            studentRepository.deleteById(id);
//        } else {
//            throw new EntityNotFoundException("Student not found with id " + id);
//        }
//    }
}
