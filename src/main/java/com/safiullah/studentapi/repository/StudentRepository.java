package com.safiullah.studentapi.repository;

import com.safiullah.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    List<Student> findByBranch(String branch);

    List<Student> findByCgpaGreaterThanEqual(Double cgpa);
}
