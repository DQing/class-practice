package com.example.demo.repository.student;

import com.example.demo.domain.Student;

import java.util.Collection;

public class StudentRepositoryImpl implements StudentRepository{
    @Override
    public Student save(Student student) {
        StudentStorage.addStudent(student);
        return student;
    }

    @Override
    public Collection<Student> findStudentByClassId(long id) {
        return StudentStorage.findStudentByClassId(id);
    }

    @Override
    public Collection<Student> findStudentByAge(long id, Integer age) {
        return StudentStorage.findStudentByAge(id, age);
    }
}
