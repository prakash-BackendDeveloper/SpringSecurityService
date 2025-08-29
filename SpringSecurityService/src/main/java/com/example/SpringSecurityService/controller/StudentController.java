package com.example.SpringSecurityService.controller;

import com.example.SpringSecurityService.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Harsh", "ai"),
                    new Student(2,"Vinith", "blockchain")
            )
    );

    @GetMapping("/admin/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
