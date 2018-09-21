package com.example.demo.repository.student;

import com.example.demo.domain.Student;

import java.util.Collection;

public interface StudentRepository {
    Student save(Student student);
    Collection<Student> findStudentByClassId(long id);

    Collection<Student> findStudentByAge(long id, Integer age);
}
