package com.simplemvc.demo.controllers;

import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.entity.Students;
import com.simplemvc.demo.service.CourseService;
import com.simplemvc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("student", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/add")
    public String addCourses(Model model){
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("course", courses);
        model.addAttribute("student", new Students());
        return "add_student";
    }

    @PostMapping("/student/add")
    public String saveStudent(
            @ModelAttribute("student") Students students){
        studentService.saveStudent(students);
        return "redirect:/students";
    }

//    @GetMapping("/add-product")
//    public String addProductForm(Model model, Principal principal){
//        if(principal == null){
//            return "redirect:/login";
//        }
//        List<Category> categories = categoryService.findAllByActivated();
//        model.addAttribute("categories", categories);
//        model.addAttribute("product", new ProductDto());
//        return "add-product";
//    }
}
