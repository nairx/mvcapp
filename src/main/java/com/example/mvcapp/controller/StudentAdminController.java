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

    @GetMapping("/add")
    public String getStudents() {
        return "student-form";
    }

    @GetMapping("/delete-confirm/{id}")
    public String confirmDelete(Model model, @PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "delete-confirm";
    }

        @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-form";
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
        return "redirect:/admin/students/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/admin/students/view";
    }

}
