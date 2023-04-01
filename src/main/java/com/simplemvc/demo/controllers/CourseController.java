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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String dashboard(Model model){
        long courseCount = courseService.courseCount();
        model.addAttribute("courseCount", courseCount);
        long studentCount = studentService.studentCount();
        model.addAttribute("studentCount", studentCount);
        return "index";
    }

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses/add")
    public String addCourses(Model model){
        Course course = new Course();
        model.addAttribute("courses", course);
        return "add_course";
    }

    @PostMapping("/courses/add")
    public String saveCourse(
            @ModelAttribute("courses") Course course
            ){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/course/view/{id}")
    public String viewCourse(
            @PathVariable Integer id, Model model
    ){
        Optional<Course> courseById = courseService.getCourseById(id);
        if (courseById.isPresent()) {
            Course course = courseById.get();
            model.addAttribute("id", course.getId());
            model.addAttribute("courseName", course.getCourseName());
            model.addAttribute("courseDescription", course.getCourseDescription());
            return "view_course";
        } else {
            return "error_404";
        }
    }

}
