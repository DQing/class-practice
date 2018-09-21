package com.example.demo.domain;

import java.util.ArrayList;

public class Clazz {

    private long id;
    private String name;

    public Clazz() {
    }

    public Clazz(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
