package com.safiullah.studentapi;

import com.safiullah.studentapi.model.Student;
import com.safiullah.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// loads some dummy data when app starts - helpful for testing
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(new Student("Md Safiullah", "safiullah0036@gmail.com", "CSE", 8.7, 2021));
        studentRepository.save(new Student("Rahul Verma", "rahul.verma@example.com", "ECE", 7.9, 2021));
        studentRepository.save(new Student("Priya Singh", "priya.singh@example.com", "CSE", 9.1, 2020));
        studentRepository.save(new Student("Amit Kumar", "amit.kumar@example.com", "ME", 7.2, 2022));
        studentRepository.save(new Student("Sneha Reddy", "sneha.reddy@example.com", "CSE", 8.5, 2021));
    }
}
