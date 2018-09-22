package com.example.demo.repository.clazz;

import com.example.demo.domain.Clazz;

import java.util.Collection;

public interface ClassRepository {
   Collection<Clazz> getClasses();
}
