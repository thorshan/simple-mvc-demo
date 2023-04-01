package com.simplemvc.demo.service.impl;


import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.entity.Students;
import com.simplemvc.demo.repository.CourseRepository;
import com.simplemvc.demo.repository.StudentRepository;
import com.simplemvc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Students saveStudent(Students students) {
        return (Students) studentRepository.save(students);
    }

    @Override
    public long studentCount() {
        return studentRepository.count();
    }
}
