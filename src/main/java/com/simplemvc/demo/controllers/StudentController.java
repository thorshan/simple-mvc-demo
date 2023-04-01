package com.simplemvc.demo.controllers;

import com.simplemvc.demo.entity.Students;
import com.simplemvc.demo.service.CourseService;
import com.simplemvc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("student", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/add")
    public String addCourses(Model model){
        Students students = new Students();
        model.addAttribute("student", students);
        return "add_student";
    }

    @PostMapping("/student/add")
    public String saveStudent(
            @ModelAttribute("student") Students students){
        studentService.saveStudent(students);
        return "redirect:/students";
    }
}
