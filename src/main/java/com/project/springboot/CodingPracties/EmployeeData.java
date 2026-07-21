package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeData {

    int id;
    String name;
    String departName;
    double salary;
    String gender;
    int age;
    int yearOfJoining;

    public EmployeeData(int id, String name, String departName, double salary,String gender,int age,int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.departName = departName;
        this.salary = salary;
        this.gender= gender;
        this.age=age;
        this.yearOfJoining=yearOfJoining;

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

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "ProblemWithEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departName='" + departName + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", yearOfJoining=" + yearOfJoining +
                '}';
    }

    public static void main(String[] args) {
        List<EmployeeData> listofEmployeeRecord = new ArrayList<>();
        listofEmployeeRecord.add(new EmployeeData(1,"laxman","HR",1000,"male",10,2010));
        listofEmployeeRecord.add(new EmployeeData(2,"Ram","finance",3000,"male",20,2015));

        listofEmployeeRecord.add(new EmployeeData(3,"sita","HR",5000,"female",30,2014));
        listofEmployeeRecord.add(new EmployeeData(4,"getta","finance",7000,"female",40,2016));
        listofEmployeeRecord.add(new EmployeeData(5,"rama","mech",2000,"female",60,2018));
        listofEmployeeRecord.add(new EmployeeData(6,"Naman","finance",2000,"male",15,2015));


        // write the code for department wise employee name
        Map<String,List<String>> departMentwiseEmployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getDepartName,Collectors.mapping(EmployeeData::getName,Collectors.toList())));
        departMentwiseEmployee.forEach((dep,empname) -> {
            System.out.println(dep + " : " +empname);
        });

        //write the thired higest salry of employee
        List<EmployeeData> thirdSalary = listofEmployeeRecord.stream().sorted(Comparator.comparing(EmployeeData::getSalary).reversed()).skip(2).findFirst().stream().toList();
        System.out.println(thirdSalary);

        //sorting salary base employee
        List<EmployeeData> salaryWiseSortingEmpl = listofEmployeeRecord.stream().sorted(Comparator.comparing(EmployeeData::getSalary)).toList();
        System.out.println(salaryWiseSortingEmpl);

        //desc order
        List<EmployeeData> deceSalaryWiseSortingEmpl = listofEmployeeRecord.stream().sorted(Comparator.comparing(EmployeeData::getSalary).reversed()).toList();
        System.out.println(deceSalaryWiseSortingEmpl);

        //how many female and male for employee class
        Map<String,Long> howmanyFemaleAndEmployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getGender,Collectors.counting()));
        howmanyFemaleAndEmployee.forEach((genders,cout) ->{
            System.out.println(genders + " : " +cout);
        });

        //print the all department name in employee
        List<String> printNameDepartment = listofEmployeeRecord.stream().map(EmployeeData::getDepartName).distinct().toList();
        System.out.println(printNameDepartment);













        //what is averge age of male and female employee
        Map<String,Double> avergeAge = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getGender,Collectors.averagingDouble(EmployeeData::getAge)));
        avergeAge.forEach((gender,averge) -> {
            System.out.println(gender + ":" +averge);
        });

        //what is highest pay employee for in org
        List<EmployeeData> higestesPay = listofEmployeeRecord.stream().max(Comparator.comparing(EmployeeData::getSalary)).stream().toList();
        System.out.println(higestesPay);

        //print the name of all employee for who has joined after 2015
        List<String> printTheName = listofEmployeeRecord.stream().filter(i -> i.getYearOfJoining() > 2015).map(EmployeeData::getName).toList();
        System.out.println(printTheName);

        //count of each employee of each deaprtment wise
        Map<String,Long> countOfEmployeeDepartMentWise = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getDepartName,Collectors.counting()));
        countOfEmployeeDepartMentWise.forEach((dep,cot) -> {
            System.out.println(dep + " : " +cot);
        });

        //what is averge salary of each departMent
        Map<String,Double> avergeSalrywiseDep = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getDepartName,Collectors.averagingDouble(EmployeeData::getSalary)));
        System.out.println(avergeSalrywiseDep);

        //youngest Name
        List<String> yougestEmployeeMaleofFinaceDepartMent = listofEmployeeRecord.stream().filter(o -> o.getDepartName()=="finance" && o.getGender()=="male").min(Comparator.comparing(EmployeeData::getAge)).map(EmployeeData::getName).stream().toList();
        System.out.println(yougestEmployeeMaleofFinaceDepartMent);


        //salarywise sorting data
        List<EmployeeData> sortD = listofEmployeeRecord.stream().sorted(Comparator.comparing(EmployeeData::getSalary).reversed()).toList();
        System.out.println(sortD);

        //prime number or not
        int primeNumber = 13;

        boolean status =IntStream.of(2 , (int) Math.sqrt(primeNumber)).noneMatch(o -> primeNumber%o==0);
        System.out.println(status);

        //higest salary of departMent wise
        Map<String, Optional<EmployeeData>> higestsalaryDeptwise = listofEmployeeRecord.stream().collect(Collectors.groupingBy(EmployeeData::getDepartName,Collectors.maxBy(Comparator.comparingDouble(EmployeeData::getSalary))));
        higestsalaryDeptwise.forEach((dep,hisalary) -> {
            System.out.println( dep + " : " + hisalary.get().getSalary());
        });




    }









}
