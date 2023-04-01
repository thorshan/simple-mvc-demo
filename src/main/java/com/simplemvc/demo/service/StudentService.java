package com.simplemvc.demo.service;

import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.entity.Students;

import java.util.List;

public interface StudentService {

    List<Students> getAllStudents();

    List<Course> getAllCourses();

    Students saveStudent(Students students);

    Students getStudentById(Integer id);

    long studentCount();
}
