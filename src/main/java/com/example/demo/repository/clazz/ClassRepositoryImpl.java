package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.student.StudentRepository;
import com.example.demo.repository.student.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public class ClassRepositoryImpl implements ClassRepository{

   @Override
   public Collection<Clazz> getClasses() {
      return ClassStorage.getClasses();
   }
}
