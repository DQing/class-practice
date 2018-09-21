package com.example.demo.controller;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.ClassRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ClassController {

    private ClassRepository classRepository = new ClassRepositoryImpl();
    @GetMapping("/classes")
    Collection<Clazz> getClasses() {
        return classRepository.getClasses();
    }

    @PostMapping("/classes")
    ResponseEntity createStudent(@RequestParam String className, @RequestBody Student student) {
       Clazz clazz =  classRepository.createStudentByClassName(className, student);
        return new ResponseEntity<>(clazz, HttpStatus.CREATED);
    }

    @GetMapping("/classes/students")
    Collection<Student> getStudents(@RequestParam String className, @RequestParam(required = false) Integer age) {
        if (age != null) {
            return classRepository.findStudentByAge(className, age);
        }
        return classRepository.findStudentByClassName(className);
    }
}
