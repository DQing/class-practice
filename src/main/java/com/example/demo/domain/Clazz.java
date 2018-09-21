package com.example.demo.domain;

import java.util.ArrayList;

public class Clazz {

    private long id;
    private String name;
    private ArrayList<Student> students;

    public Clazz() {
    }

    public Clazz(long id, String name, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
