package com.safiullah.studentapi.service;

import com.safiullah.studentapi.model.Student;
import com.safiullah.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        // check if email already exists
        Optional<Student> existing = studentRepository.findByEmail(student.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Student with this email already exists");
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedData) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        student.setName(updatedData.getName());
        student.setBranch(updatedData.getBranch());
        student.setCgpa(updatedData.getCgpa());
        student.setAdmissionYear(updatedData.getAdmissionYear());
        // not updating email to keep it unique identifier

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }

    public List<Student> getTopStudents(Double minCgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(minCgpa);
    }
}
