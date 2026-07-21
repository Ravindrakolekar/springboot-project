package com.project.springboot.controller;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PractiesData {
    public static void main(String[] args) {
        //stream
        List<Integer> l = Arrays.asList(2,4,5,6,9,8,9);
        List<Integer> s = l.stream().map(o -> o *2).toList();
        System.out.println(s);

        //duplicate
        List<Integer> ls = Arrays.asList(45,66,96,88,66,88,45);
        List<Integer> du = ls.stream().distinct().toList();
        System.out.println(du);

        // find the duplicate value in int array
        int[] b = {4,4,5,6,7,5,8,9};
        List<Integer> finddu = Arrays.stream(b).boxed()
                .collect(Collectors.groupingBy(i -> i,Collectors.counting()))
                .entrySet().stream().filter(o -> o.getValue() > 1).map(Map.Entry::getKey).toList();

        System.out.println(finddu);

        // Q 33 remove the duplicate element in array

        int[] el = {7,5,4,3,8,5,2,1,4};
        List<Integer> rd = Arrays.stream(el).boxed().distinct().toList();
        System.out.println(rd);

        //Q 32 remove the duplicate in string

        String duplicateString = "aabbccddeff";
        String r = duplicateString.
                toLowerCase()
                .chars()
                .mapToObj(t -> String.valueOf((char)t))
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(r);

        //Q 31.find the top 3 highest salary in list
        List<Integer> topEmployeeNumber = Arrays.asList(500,400,300,100,200,700,1000,500);
        List<Integer> find = topEmployeeNumber.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(find);

        // Q 30. seperate the integer / String values and String value
        String abc ="aabbc1123";
        String in = abc.chars().mapToObj(t -> (char)t).filter(Character::isDigit).map(String::valueOf).collect(Collectors.joining());
        System.out.println(in);

        // Q.29 find the list of duplicate word
        List<String> words = Arrays.asList("test","pest","test","java","test");
        List<String> dw = words.stream().filter( names -> Collections.frequency(words,names) > 1).distinct().collect(Collectors.toList());
        System.out.println(dw);

        //Q26 Two array merging
        int[] m1 = {1, 3, 3, 6, 6, 7, 9, 0};
        int[] m2 = {5, 7, 8, 5, 4, 3};

        int[] mergArray = IntStream.concat(Arrays.stream(m1),Arrays.stream(m2)).toArray();

        System.out.println(Arrays.toString(mergArray));

        //



    }



}
