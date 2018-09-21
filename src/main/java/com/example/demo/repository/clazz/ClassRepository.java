package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;

import java.util.Collection;

public interface ClassRepository {
   Collection<Clazz> getClasses();

   Student createStudentById(long id, Student student);

   Collection<Student> findStudentById(long id);

   Collection<Student> findStudentByAge(long id, Integer age);
}
