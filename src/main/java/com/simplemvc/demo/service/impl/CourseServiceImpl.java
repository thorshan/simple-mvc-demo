package com.simplemvc.demo.service.impl;

import com.simplemvc.demo.entity.Course;
import com.simplemvc.demo.repository.CourseRepository;
import com.simplemvc.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public long courseCount() {
        return courseRepository.count();
    }


}
