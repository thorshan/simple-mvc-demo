package com.simplemvc.demo.repository;

import com.simplemvc.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Integer> {
}
