package com.example.demo.repository;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;

import java.util.Collection;
import java.util.List;

public class ClassRepositoryImpl implements ClassRepository{
   @Override
   public Collection<Clazz> getClasses() {
      return ClassStorage.getClasses();
   }

   @Override
   public Clazz createStudentByClassName(String className, Student student) {
      return ClassStorage.createStudentByClassId(className, student);
   }

   @Override
   public Collection<Student> findStudentByClassName(String className) {
      return ClassStorage.findStudentByClassName(className);
   }

   @Override
   public Collection<Student> findStudentByAge(String className, int age) {
      return ClassStorage.findStudentByAge(className, age);
   }
}
