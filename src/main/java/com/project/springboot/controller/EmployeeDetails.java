package com.project.springboot.controller;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDetails {
    int id;
    String name;
    String departmentName;
    double Salary;

    public EmployeeDetails(int id, String name, String departmentName, double salary) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
        Salary = salary;
    }

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }


    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<EmployeeDetails> list = new ArrayList<>();
        list.add(new EmployeeDetails(1,"Ravindra","HR",400));
        list.add(new EmployeeDetails(2,"Vijay","MECH",3000));
        list.add(new EmployeeDetails(3,"Kumar","TAX",100));
        list.add(new EmployeeDetails(4,"Pravin","TAX",200));
        list.add(new EmployeeDetails(5,"Suraj","FINANCE",100));

        // print the department wise only name print
        Map<String, List<String>> departmentwiseEmployee  =  list.stream().collect(Collectors.
                groupingBy(EmployeeDetails::getDepartmentName, Collectors.mapping(EmployeeDetails::getName,Collectors.toList())));

        departmentwiseEmployee.forEach((dep,emp) -> {

            System.out.println(dep + " " + emp);
        });

        System.out.println("***************************");

        // below salary name
        list.stream().filter(o -> o.getSalary() > 200).map(i -> i.getName()).forEach(p -> System.out.println(p));
        list.stream().filter(o -> o.getSalary() > 200).map(EmployeeDetails::getName).forEach(y -> System.out.println(y));

        //System.out.println(departmentwiseEmployee);

        String str = "aabbcdcceeA";

        Map<Character,Long> frquencyEachCharacterCount  = str.toLowerCase().chars().mapToObj(t -> (char)t).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Character Squance" + frquencyEachCharacterCount);

        // same Character count but output like "a3b3"

        String abc = frquencyEachCharacterCount.entrySet().stream().map(i -> i.getKey() + "" + i.getValue()).collect(Collectors.joining());
        System.out.println(abc);

        System.out.println("*****************************************************************************");
        //Ascending and Number
        List<Integer> intNumber = Arrays.asList(12,56,89,96,10,78);
        List<Integer> sortingAscendingNumber = intNumber.stream().sorted().toList();
        System.out.println("Ascending Number :: " +sortingAscendingNumber);

        List<Integer> sortingDecedingNumber = intNumber.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Descending Number :: " +sortingDecedingNumber);

        //print the second number

        Integer highestSecondNumber = intNumber.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("highest second Number :: " + highestSecondNumber);


        //write the program in right corner shifted zero with normal program

        int[] arr = {3,2,0,7,0,5,6};

        int[] out = new int[arr.length];
        int cout = 0;
        for (int n : arr){
            if(n!=0){
                out[cout++] = n;
            }

        }
        System.out.println(Arrays.toString(out));

        //using java 8 in right zero shifted

        // same program using java 8 non zero program
        List<Integer> nonZeroValue = Arrays.stream(arr).filter( p -> p!=0).boxed().collect(Collectors.toList());

        long count1 = Arrays.stream(arr).filter(o -> o == 0).count();

        for(int v = 0 ; v < count1 ; v++){
            nonZeroValue.add(0);
        }

        System.out.println(nonZeroValue);

        // output in group of string of array [[eat, tea, ate], [pot, opt], [abc]]

        String[] nameOfstring = {"eat","tea","abc","pot","opt","ate"};

        Map<String,List<String>> listofgroup = Arrays.stream(nameOfstring).collect(Collectors.groupingBy(o -> {

            char[] c = o.toCharArray();
            Arrays.sort(c);
            return new String(c);

        }));

        List<List<String>> output = new ArrayList<>(listofgroup.values());
        System.out.println(output);

        // Duplicate record removed
        String str1 = "aabbBccddeeA";
        Map<Character,Long> valueOfLong = str1.chars().mapToObj( t -> (char)t).collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        valueOfLong.entrySet().stream().filter(o -> o.getValue() > 1).forEach(u -> System.out.println(u.getKey()));

        //String str1="abcade";
        //output like ="abc" not if find first character in duplicate then  print only before character

        String stringName = "abcade";
        StringBuffer stringBuffer = new StringBuffer();
        Set<Character> characters = new HashSet<>();

        for(char c : stringName.toCharArray()){
            if(characters.contains(c)){
                break;
            }
            characters.add(c);
            stringBuffer.append(c);
        }
        System.out.println(stringBuffer);


        //write the code for example "java" , "aws"  --->>  "Java" ,"Aws" output like first character capital
        String[] name = {"java","aws","test","pest"};

        List<String> toUpperCaseFirstCharacter = Arrays.stream(name).map(o -> o.substring(0,1).toUpperCase() + "" + o.substring(1)).toList();
        System.out.println(toUpperCaseFirstCharacter);

        //write the code for upper case and lower case in string example "aBcD"  --->> "AbCd";

        String upperAndLowerCase = "aBcD";
        String result = upperAndLowerCase.chars().mapToObj(c -> {
            char ch = (char) c;
            return Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
        }).map(String::valueOf).collect(Collectors.joining());

        System.out.println("upper and lower case :: " + result);


        //maximum subarray problem
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // currentMax = Math.max(nums[i], currentMax + nums[i]);
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
            } else {
                currentMax = currentMax + nums[i];
            }

            // maxSoFar = Math.max(maxSoFar, currentMax);
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
            }
        }

        System.out.println("Maximum Subarray Sum = " + maxSoFar);
        // Output: 6

    }
}
