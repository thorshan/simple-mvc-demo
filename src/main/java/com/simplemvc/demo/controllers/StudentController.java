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
        model.addAttribute("course", courseService.getAllCourses());
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

    @GetMapping("/student/edit/{id}")
    public String editStudent(
            @PathVariable("id") Integer id, Model model
    ){
        model.addAttribute("course", courseService.getAllCourses());
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/student/edit/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Students students,
                                Model model) {

        Students existingStudent = studentService.getStudentById(id);
        existingStudent.setId(students.getId());
        existingStudent.setName(students.getName());
        existingStudent.setEmail(students.getEmail());
        existingStudent.setGender(students.getGender());
        existingStudent.setDob(students.getDob());
        existingStudent.setPhone(students.getPhone());
        existingStudent.setCourse(students.getCourse());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
