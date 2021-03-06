package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public static Clazz findClass(long id) {
       return CLAZZES.get(id);
    }
}
