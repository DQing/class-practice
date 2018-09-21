package com.example.demo;

import com.example.demo.controller.ClassController;
import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;
import com.example.demo.repository.clazz.ClassStorage;
import com.example.demo.repository.student.StudentStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
        StudentStorage.clear();
    }

    private void setupData() {
        Student student1 = new Student(1,"zhang san",25, 1);
        Student student2 = new Student(2,"xiao hong",12, 1);

        Student student3 = new Student(3,"wang wu",24, 2);
        Student student4 = new Student(4,"li si",28, 2);

        StudentStorage.addStudent(student1, student2, student3, student4);

        Clazz clazz1 = new Clazz(1, "1 班");
        Clazz clazz2 = new Clazz(2, "2 班");

        ClassStorage.addClass(clazz1, clazz2);
    }


    @Test
    void should_return_class() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("1 班"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].name").value("2 班"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(status().isOk());
    }

    @Test
    void should_create_student_for_3() throws Exception{
        setupData();
        Student student = new Student(5, "dou qingqing", 24, 1);
        mockMvc.perform(post("/api/classes/1")
                .param("className", "3 班")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.name").value("dou qingqing"))
                .andExpect(jsonPath("$.age").value(24))
                .andExpect(status().isCreated());
    }

    @Test
    void should_query_student_in_class_1() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes/1/students"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("zhang san"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("xiao hong"))
                .andExpect(status().isOk());

    }

    @Test
    void should_get_age_big_than_20() throws Exception {
        setupData();
        mockMvc.perform(get("/api/classes/1/students")
                .param("age","20"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("zhang san"))
                .andExpect(status().isOk());
    }
}
