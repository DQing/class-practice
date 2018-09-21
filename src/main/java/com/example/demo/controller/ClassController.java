package com.example.demo.controller;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.clazz.ClassRepository;
import com.example.demo.repository.clazz.ClassRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/classes")
    Collection<Clazz> getClasses() {
        return classRepository.getClasses();
    }

    @PostMapping("/classes/{id}")
    ResponseEntity createStudent(@PathVariable long id, @RequestBody Student student) {
       Student result =  classRepository.createStudentById(id, student);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/classes/{id}/students")
    ResponseEntity getStudents(@PathVariable long id) {
        Collection<Student> studentById = classRepository.findStudentById(id);
        if (studentById == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping(value = "/classes/{id}/students", params = "age")
    ResponseEntity getStudentsFilterAge(@PathVariable long id, @RequestParam int age) {
        Collection<Student> studentByAge = classRepository.findStudentByAge(id, age);
        if (studentByAge == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentByAge, HttpStatus.OK);
    }
}
