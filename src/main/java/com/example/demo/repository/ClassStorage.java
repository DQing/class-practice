package com.example.demo.repository;

import com.example.demo.domain.Clazz;
import com.example.demo.domain.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ClassStorage {

    private static final Map<Long, Clazz> CLAZZES = new HashMap<>();


    static Collection<Clazz> getClasses() {
        return CLAZZES.values();
    }

    public static void addClass(Clazz...clazz) {
        Arrays.stream(clazz).forEach(item -> CLAZZES.put(item.getId(), item));
    }

    public static void clear() {
        CLAZZES.clear();
    }

    static Clazz createStudentByClassId(String className, Student student) {
        long[] valueHolder = new long[1];
        CLAZZES.forEach((key,value)->{
            if (value.getName().equals(className)) {
                value.getStudents().add(student);
                valueHolder[0] = key;
            }
        });
        return CLAZZES.get(valueHolder[0]);
    }

    static Collection<Student> findStudentByClassName(String className) {
        long[] valueHolder = getClassId(className);
        return CLAZZES.get(valueHolder[0]).getStudents();
    }

    static Collection<Student> findStudentByAge(String className, int age) {
        long[] valueHolder = getClassId(className);
        return CLAZZES.get(valueHolder[0]).getStudents().stream().filter(student -> student.getAge() > age).collect(Collectors.toList());
    }

    private static long[] getClassId(String className) {
        long[] valueHolder = new long[1];
        CLAZZES.forEach((key, value) -> {
            if (value.getName().equals(className)) {
                valueHolder[0] = key;
            }
        });
        return valueHolder;
    }
}
