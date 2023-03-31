package com.simplemvc.demo.repository;

import com.simplemvc.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer> {

}
