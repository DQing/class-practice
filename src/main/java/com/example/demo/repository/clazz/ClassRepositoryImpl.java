package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.student.StudentRepository;
import com.example.demo.repository.student.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ClassRepositoryImpl implements ClassRepository{

   @Autowired
   private StudentRepository studentRepository;

   @Override
   public Collection<Clazz> getClasses() {
      return ClassStorage.getClasses();
   }

   @Override
   public Student createStudentById(long id, Student student) {
      if (ClassStorage.findClass(id) != null) {
         return studentRepository.save(student);
      }
      return null;
   }

   @Override
   public Collection<Student> findStudentById(long id) {
      if (ClassStorage.findClass(id) != null) {
         return studentRepository.findStudentByClassId(id);
      }
      return null;
   }

   @Override
   public Collection<Student> findStudentByAge(long id, Integer age) {
      if (ClassStorage.findClass(id) != null) {
         return studentRepository.findStudentByAge(id, age);
      }
      return null;
   }
}
