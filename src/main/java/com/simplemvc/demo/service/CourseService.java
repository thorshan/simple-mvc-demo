package com.simplemvc.demo.service;

import com.simplemvc.demo.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course saveCourse(Course course);

    long courseCount();
}
