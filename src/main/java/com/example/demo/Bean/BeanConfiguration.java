package com.example.demo.Bean;

import com.example.demo.repository.clazz.ClassRepository;
import com.example.demo.repository.clazz.ClassRepositoryImpl;
import com.example.demo.repository.student.StudentRepository;
import com.example.demo.repository.student.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanConfiguration {

    @Bean
    ClassRepository createClassRepository() {
        return new ClassRepositoryImpl();
    }

    @Bean
    StudentRepository createStudentRepository() {
        return new StudentRepositoryImpl();
    }
}
