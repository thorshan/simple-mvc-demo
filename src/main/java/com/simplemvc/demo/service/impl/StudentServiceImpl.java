package com.simplemvc.demo.service.impl;


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

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students saveStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public Students getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Students updateStudent(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public long studentCount() {
        return studentRepository.count();
    }
}
