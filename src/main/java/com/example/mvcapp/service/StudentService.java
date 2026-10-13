package com.example.mvcapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.mvcapp.entity.Student;
import com.example.mvcapp.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents(Model model) {
        return studentRepository.findAll();

    }

    public boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

}
