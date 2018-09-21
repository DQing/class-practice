package com.example.demo.repository.student;

import com.example.demo.domain.Student;

import java.util.*;

public class StudentStorage {

    private static final Map<Long, Student> STUDENTS = new HashMap<>();


    public static void addStudent(Student...students) {
        Arrays.stream(students).forEach(student -> STUDENTS.put(student.getId(), student));
    }

    public static Collection<Student> findStudentByClassId(long id) {
        List<Student> students = new ArrayList<>();
        STUDENTS.forEach((key, value) -> {
            if (value.getClassId() == id) {
                students.add(value);
            }
        });
        return students;
    }

    public static Collection<Student> findStudentByAge(long id, Integer age) {
        List<Student> students = new ArrayList<>();
        STUDENTS.forEach((key, value) -> {
            if (value.getClassId() == id && value.getAge() > age) {
                students.add(value);
            }
        });
        return students;
    }

    public static void clear() {
        STUDENTS.clear();
    }

    public static Collection<Student> getStudent() {
        return STUDENTS.values();
    }
}
