package com.example.demo.controller;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.clazz.ClassRepository;
import com.example.demo.repository.student.StudentRepository;
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

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/classes")
    Collection<Clazz> getClasses() {
        return classRepository.getClasses();
    }

    @PostMapping("/classes/{classId}")
    ResponseEntity createStudent(@PathVariable long classId, @RequestBody Student student) {
        Student result = studentRepository.createStudent(classId,student);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/classes/{classId}/students")
    ResponseEntity getStudents(@PathVariable long classId) {
        Collection<Student> studentById = studentRepository.findStudentByClassId(classId);
        if (studentById == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping(value = "/classes/{classId}/students", params = "age")
    ResponseEntity getStudentsFilterAge(@PathVariable long classId, @RequestParam int age) {
        Collection<Student> studentByAge = studentRepository.findStudentByClassIdAndAge(classId, age);
        if (studentByAge == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentByAge, HttpStatus.OK);
    }
}
