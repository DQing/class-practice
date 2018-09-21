package com.example.demo.repository.clazz;

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