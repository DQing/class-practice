package com.example.demo.repository.student;

import com.example.demo.domain.Student;
import com.example.demo.repository.clazz.ClassStorage;

import java.util.Collection;

public class StudentRepositoryImpl implements StudentRepository{
    @Override
    public Student save(Student student) {
        StudentStorage.addStudent(student);
        return student;
    }

    @Override
    public Collection<Student> findStudentByClassId(long classId) {
        if (ClassStorage.findClass(classId) != null) {
            return StudentStorage.findStudentByClassId(classId);
        }
        return null;
    }

    @Override
    public Collection<Student> findStudentByClassIdAndAge(long classId, Integer age) {
        return StudentStorage.findStudentByClassIdAndAge(classId, age);
    }

    @Override
    public Student createStudent(long classId, Student student) {
        if (ClassStorage.findClass(classId) != null) {
            return StudentStorage.createStudent(student);
        }
        return null;
    }

}
