package com.example.demo;

import com.example.demo.controller.ClassController;
import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.ClassStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ClassControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = standaloneSetup(ClassController.class).build();
        ClassStorage.clear();
    }

    private void setupData() {
        Student student1 = new Student(1,"zhang san",25);
        Student student2 = new Student(2,"xiao hong",22);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Clazz clazz1 = new Clazz(3, "3 班", students);

        Student student3 = new Student(3,"wang wu",24);
        Student student4 = new Student(4,"li si",28);
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student3);
        studentList.add(student4);
        Clazz clazz2 = new Clazz(5, "5 班", studentList);
        ClassStorage.addClass(clazz1, clazz2);
    }


    @Test
    void should_return_class() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("3 班"))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(status().isOk());
    }

    @Test
    void should_create_student_for_3() throws Exception{
        setupData();
        Student student = new Student(5, "dou qingqing", 24);
        mockMvc.perform(post("/api/classes")
                .param("className", "3 班")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("3 班"))
                .andExpect(jsonPath("$.students[2].id").value(5))
                .andExpect(jsonPath("$.students[2].name").value("dou qingqing"))
                .andExpect(jsonPath("$.students[2].age").value(24))
                .andExpect(status().isCreated());
    }

    @Test
    void should_query_student_in_class_5() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes/students")
                .param("className", "5 班"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("wang wu"))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].name").value("li si"))
                .andExpect(status().isOk());

    }

    @Test
    void should_get_age_big_than_20() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes/students")
                .param("className", "5 班")
                .param("age","20"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].name").value("wang wu"))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].name").value("li si"))
                .andExpect(status().isOk());
    }
}
