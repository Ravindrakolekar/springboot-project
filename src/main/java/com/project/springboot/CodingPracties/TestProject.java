package com.project.springboot.CodingPracties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestProject {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1001, 1002, 1001, 1003, 1002, 1002);
        Map<Integer, Long> ouuernceData = numbers.stream()
                .collect(Collectors.groupingBy(y -> y, Collectors.counting()));

        ouuernceData.forEach((occ, cout) -> {
            System.out.println(occ + " " + cout);
        });

        ouuernceData.entrySet().stream().
                sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).forEach(c -> System.out.println(c.getKey() + "" + c.getValue()));

        System.out.println(ouuernceData);

        String str = "madam ";

        boolean staus = IntStream.rangeClosed(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
        System.out.println(staus);

        StringBuilder sb = new StringBuilder(str);
        for (int i = sb.length() - 1; i >= 0; i--) {
            System.out.println(sb.charAt(i));
        }
    }
}