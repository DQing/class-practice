package com.example.demo.domain;

public class Student {

    private long id;
    private String name;
    private int age;
    private long classId;

    public Student() {
    }

    public Student(long id, String name, int age, long classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classId = classId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getClassId() {
        return classId;
    }
}
