package com.project.springboot.controller;

import java.util.Objects;

public class TestClass {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        TestClass testClass = (TestClass) o;
        return id == testClass.id && Objects.equals(name, testClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
