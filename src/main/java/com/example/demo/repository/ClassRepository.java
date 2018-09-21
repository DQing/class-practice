package com.example.demo.repository;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;

import java.util.Collection;

public interface ClassRepository {
   Collection<Clazz> getClasses();

   Clazz createStudentByClassName(String className, Student student);

   Collection<Student> findStudentByClassName(String className);

   Collection<Student> findStudentByAge(String className, int age);
}
