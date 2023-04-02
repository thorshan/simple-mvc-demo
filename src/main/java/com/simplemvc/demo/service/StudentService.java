package com.simplemvc.demo.service;

import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.entity.Students;

import java.util.List;

public interface StudentService {

    List<Students> getAllStudents();

    Students saveStudent(Students students);

    Students getStudentById(Integer id);

    Students updateStudent(Students students);

    void deleteStudentById(Integer id);

    long studentCount();
}
