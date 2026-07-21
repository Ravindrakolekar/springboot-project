package com.project.springboot.CodingPracties;

import java.util.Map;
import java.util.stream.Collectors;


interface A{
    void test();
}
interface B {
    void test();
}
public class ProjectCode implements A,B{

    @Override
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ProjectCode projectCode = new ProjectCode();
        projectCode.test();

    }
}
