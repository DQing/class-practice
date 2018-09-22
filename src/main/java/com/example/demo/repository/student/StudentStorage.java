package com.example.demo.repository.student;

import com.example.demo.domain.Student;

import java.util.*;

public class StudentStorage {

    private static final Map<Long, Student> STUDENTS = new HashMap<>();


    public static void addStudent(Student...students) {
        Arrays.stream(students).forEach(student -> STUDENTS.put(student.getId(), student));
    }

    public static Collection<Student> findStudentByClassId(long classId) {
        List<Student> students = new ArrayList<>();
        STUDENTS.forEach((key, value) -> {
            if (value.getClassId() == classId) {
                students.add(value);
            }
        });
        return students;
    }

    public static Collection<Student> findStudentByClassIdAndAge(long classId, Integer age) {
        List<Student> students = new ArrayList<>();
        STUDENTS.forEach((key, value) -> {
            if (value.getClassId() == classId && value.getAge() > age) {
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

    public static Student createStudent(Student student) {
         STUDENTS.put(student.getId(), student);
        return STUDENTS.get(student.getId());
    }
}
