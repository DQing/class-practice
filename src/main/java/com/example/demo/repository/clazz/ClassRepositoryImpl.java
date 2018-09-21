package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.student.StudentRepository;
import com.example.demo.repository.student.StudentRepositoryImpl;

import java.util.Collection;

public class ClassRepositoryImpl implements ClassRepository{

   private StudentRepository studentRepository = new StudentRepositoryImpl();
   @Override
   public Collection<Clazz> getClasses() {
      return ClassStorage.getClasses();
   }

   @Override
   public Student createStudentById(long id, Student student) {
      return studentRepository.save(student);
   }

   @Override
   public Collection<Student> findStudentById(long id) {
      return studentRepository.findStudentByClassId(id);
   }

   @Override
   public Collection<Student> findStudentByAge(long id, Integer age) {
      return studentRepository.findStudentByAge(id, age);
   }
}
