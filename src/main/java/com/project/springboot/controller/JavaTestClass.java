package com.project.springboot.controller;

import com.beust.ah.A;

import java.util.*;
import java.util.stream.Collectors;

public class JavaTestClass {
    public static void main(String[] args) {

        // group of same string in same array
        String[] str = {"eat","tea","abc","pot","opt","ate"};

       /* Map<String, List<String>> grouped = Arrays.stream(str)
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return  new String(chars);
                }));


        List<List<String>> result = new ArrayList<>(grouped.values());
        System.out.println(result);*/

        // new Code

        Map<String, List<String>> result1 = Arrays.stream(str).collect(Collectors.groupingBy(p -> {
            char[] c = p.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        List<List<String>> ans = new ArrayList<>(result1.values());
        System.out.println(ans);

        //Given a string, write a Java 8 program to print the substring up to the
        // first repeated character. Once a character repeats, stop and output the substring formed so far
        //String str1="abcade";
        //output like ="abc" not if find first character in duplicate then then print only

        String repatedString = "kumaru";

        StringBuffer stringBuffer = new StringBuffer();
        Set<Character> charctorCheck = new HashSet<>();

        for(char c : repatedString.toCharArray()){
            if(charctorCheck.contains(c)){
                break;
            }
            charctorCheck.add(c);
            stringBuffer.append(c);
        }

        System.out.println(stringBuffer);


        //how to find power of 2 if Yes then return true and false

        int number = 5;
        boolean isFlag = false;

        isFlag = (number & (number - 1)) == 0;

        System.out.println("power of 2 values :: " + isFlag);

        //***********************************************************************

        int[] arr = {3, 2, 0, 6, 0, 8, 7, 0, 6};

        /*int count=0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }while (count<arr.length)
            {
                arr[count++]=0;
            }
        System.out.println(Arrays.toString(arr));*/

        int[] output = new int[arr.length];
        int count = 0;
        for(int num : arr){
            if(num!=0){
                output[count++] = num;
            }

        }
        System.out.println("Ans ::" + Arrays.toString(output));


        //***********************************************
        int i = 16 ;

        Boolean b = b(i);
        System.out.println(b);

        // same program using java 8 non zero program
        List<Integer> nonZeroValue = Arrays.stream(arr).filter( p -> p!=0).boxed().collect(Collectors.toList());

        long count1 = Arrays.stream(arr).filter(o -> o == 0).count();

        for(int v = 0 ; v < count1 ; v++){
            nonZeroValue.add(0);
        }

        System.out.println(nonZeroValue);



    }

    private static boolean b(int i){

        return (i & (i - 1)) == 0;

    }
}


