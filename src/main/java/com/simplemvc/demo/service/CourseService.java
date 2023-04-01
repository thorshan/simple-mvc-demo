package com.simplemvc.demo.service;

import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.entity.Students;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Optional<Course> getCourseById(Integer id);

    long courseCount();
}
