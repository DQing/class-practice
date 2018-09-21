package com.example.demo.controller;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.clazz.ClassRepository;
import com.example.demo.repository.clazz.ClassRepositoryImpl;
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

    @PostMapping("/classes/{id}")
    ResponseEntity createStudent(@PathVariable long id, @RequestBody Student student) {
       Student result =  classRepository.createStudentById(id, student);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/classes/{id}/students")
    Collection<Student> getStudents(@PathVariable long id, @RequestParam(required = false) Integer age) {
        if (age != null) {
            return classRepository.findStudentByAge(id, age);
        }
        return classRepository.findStudentById(id);
    }
}
