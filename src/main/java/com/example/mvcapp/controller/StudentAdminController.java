package com.example.mvcapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.mvcapp.entity.Student;
import com.example.mvcapp.service.StudentService;

@Controller
@RequestMapping("/admin/students")
public class StudentAdminController {

    private StudentService studentService;

    public StudentAdminController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/view")
    public String getStudents(Model model) {
        List<Student> students = studentService.getStudents(null);
        model.addAttribute("students", students);
        return "student";
    }

    @PostMapping("/save")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/view";
    }

}
