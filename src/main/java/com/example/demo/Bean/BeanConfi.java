package com.example.demo.Bean;

import com.example.demo.repository.clazz.ClassRepositoryImpl;
import com.example.demo.repository.student.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfi {

    @Bean
    ClassRepositoryImpl createClassRepository() {
        return new ClassRepositoryImpl();
    }

    @Bean
    StudentRepositoryImpl createStudentRepository() {
        return new StudentRepositoryImpl();
    }
}
