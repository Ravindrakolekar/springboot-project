package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemWithEmployee {

    int id;
    String name;
    String departName;
    double salary;
    String gender;
    int age;
    int yearOfJoining;

    public ProblemWithEmployee(int id, String name, String departName, double salary,String gender,int age,int yearOfJoining) {
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

        List<ProblemWithEmployee> listofEmployeeRecord = new ArrayList<>();
        listofEmployeeRecord.add(new ProblemWithEmployee(1,"laxman","HR",1000,"male",10,2010));
        listofEmployeeRecord.add(new ProblemWithEmployee(2,"Ram","finance",3000,"male",20,2015));
        listofEmployeeRecord.add(new ProblemWithEmployee(3,"sita","HR",5000,"female",30,2014));
        listofEmployeeRecord.add(new ProblemWithEmployee(4,"getta","finance",7000,"female",40,2016));
        listofEmployeeRecord.add(new ProblemWithEmployee(5,"rama","mech",2000,"female",60,2018));




        // write the code for department wise employee name
        Map<String,List<String>> departMentWiseEmployee = listofEmployeeRecord
                .stream()
                .collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.mapping(ProblemWithEmployee::getName,Collectors.toList())));

        departMentWiseEmployee.forEach((dep,emp) -> {
            System.out.println(dep  +  " : " +emp );
        });

        //third-highest salary of employee
        List<ProblemWithEmployee> thiredHigestSalaryEmployee = listofEmployeeRecord.stream()
                .sorted(Comparator.comparing(ProblemWithEmployee::getSalary)
                        .reversed())
                .distinct().skip(2).findFirst().stream().toList();
        System.out.println("highest third salary of employee :: " + thiredHigestSalaryEmployee);




        //sorting of salary base employee
        List<ProblemWithEmployee> sortingOfEmployeeViaSalaryBase = listofEmployeeRecord.stream().sorted(Comparator.comparing(ProblemWithEmployee::getSalary)).toList();
        System.out.println("\n"+sortingOfEmployeeViaSalaryBase);


        //descending of salary base employee
        List<ProblemWithEmployee> descendingOfEmployeeViaSalaryBase = listofEmployeeRecord.stream().sorted(Comparator.comparing(ProblemWithEmployee::getSalary).reversed()).toList();
        System.out.println(descendingOfEmployeeViaSalaryBase);

        //how many female and male for employee class
        Map<String,Long> howManyFemaleAndMaleEmployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.counting()));
        System.out.println(howManyFemaleAndMaleEmployee);

        //print the all department name in employee
        List<String> printDepartMentName = listofEmployeeRecord.stream().map(ProblemWithEmployee::getDepartName).distinct().toList();
        System.out.println(printDepartMentName);

        //what is averge age of male and female employee
        Map<String,Double> avergeOfMaleAndFemaleEmployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.averagingDouble(ProblemWithEmployee::getAge)));
        System.out.println(avergeOfMaleAndFemaleEmployee);


        //what is highest pay employee for in org
        List<ProblemWithEmployee> higestPayEmployee = listofEmployeeRecord.stream().max(Comparator.comparing(ProblemWithEmployee::getSalary)).stream().toList();
        System.out.println("highest Salary employee details :: " + higestPayEmployee);

        //print the name of all employee for who has joined after 2015
        List<ProblemWithEmployee> listOfAllEmployeeWhoJoined2015 = listofEmployeeRecord.stream().filter(i -> i.getYearOfJoining() > 2015).toList();
        System.out.println("list of all employee :: " + listOfAllEmployeeWhoJoined2015);

        //count of each employee of each deaprtment wise
        Map<String,Long> eachCountEmployeeDepartMentWise = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.counting()));
        System.out.println(eachCountEmployeeDepartMentWise);

        //what is averge salary of each departMent
        Map<String,Double> avergeSalaryEachDepartment = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.averagingDouble(ProblemWithEmployee::getSalary)));
        System.out.println("avg salary for department :: " +avergeSalaryEachDepartment);

        //youngest employee male of finance department
        List<ProblemWithEmployee> yougestEmployee = listofEmployeeRecord.stream().filter(p -> p.getDepartName() == "finance").min(Comparator.comparing(ProblemWithEmployee::getAge)).stream().toList();
        System.out.println(yougestEmployee);

        //How many male and female employee of finace department
        Map<String,Long> howManyMaleAndEmployeFinance = listofEmployeeRecord.stream()
                .filter(p -> p.getDepartName()=="finance")
                .collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.counting()));
        System.out.println("how many male and female employee of finance department :: " + howManyMaleAndEmployeFinance);

        //averge salary male and female employee
        Map<String,Double> maleAndFemaleAvgSalary = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.averagingDouble(ProblemWithEmployee::getSalary)));
        System.out.println("avg salary for male and female employee :: " + maleAndFemaleAvgSalary);



        //sorting of salary wise
        List<String> sortingOfEmployee = listofEmployeeRecord
                .stream()
                .sorted(Comparator.comparing(ProblemWithEmployee::getSalary).reversed())
                .map(ProblemWithEmployee::getName)
                .toList();

        //simple code for reversing string
        String s ="ravindra";
        int len = s.length();
        String rv ="";
        for(int i = len - 1 ; i >= 0; i--){

            rv = rv + s.charAt(i);

        }
        System.out.println(rv);

        //prime number or no
        int padNumber = 5;
        boolean palidromeStatus = IntStream.rangeClosed(2 , (int) Math.sqrt(padNumber)).noneMatch(o -> padNumber%o==0);
        System.out.println(palidromeStatus);

        //higest salary of departMent wise
        Map<String,Optional<ProblemWithEmployee>> highestSalaryOfDepartMent = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.maxBy(Comparator.comparingDouble(ProblemWithEmployee::getSalary))));

        highestSalaryOfDepartMent.forEach((dep,emp) -> {
            System.out.println(dep+ "higest salary" + emp.get().salary);
        });
        System.out.println(highestSalaryOfDepartMent);

        //department wise employee name
        Map<String,List<String>> departmentwiseName = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.mapping(ProblemWithEmployee::getName,Collectors.toList())));

        departmentwiseName.forEach((depp, empp) -> {
            System.out.println(depp + ":" + empp);
        });


        Map<String,Optional<ProblemWithEmployee>> maxSalaryDeptWise = listofEmployeeRecord
                .stream()
                .collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName ,Collectors.maxBy(Comparator.comparingDouble(ProblemWithEmployee::getSalary))));

        maxSalaryDeptWise.forEach((dep , cot) -> {
            System.out.println(dep + " " + cot.get().getSalary());
        });






        /*// All program for the Employee details.
        //Q1 write the code for employee name for department wise
        Map<String, List<String>> listOfEmployee =listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.mapping(ProblemWithEmployee::getName,Collectors.toList())));
        listOfEmployee.forEach((dep,empname) -> {
            System.out.println(dep + " " + empname);
        });

        //Q2.writhe the third highest salary with name
        List<String> thirdSalaryHighest = listofEmployeeRecord.stream().sorted(Comparator.comparing(ProblemWithEmployee::getSalary).reversed()).map(ProblemWithEmployee::getName).skip(2).findFirst().stream().toList();
        System.out.println("higest 3rd salary :: " +thirdSalaryHighest);

        //Q3.female and male in list gender wise
        Map<String,List<String>> howManyFemaleAndMaleEmployee = listofEmployeeRecord
                .stream()
                .collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.mapping(ProblemWithEmployee::getName,Collectors.toList())));

        howManyFemaleAndMaleEmployee.forEach((genders,names) -> {
            System.out.println(genders + " " +names);
        });

        //Q4.count of male and female
        Map<String,Long> countOfMaleAndFemale = listofEmployeeRecord
                .stream()
                .collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.counting()));
        System.out.println(": : " + countOfMaleAndFemale);

        //Q5 print the name of all department
        List<String> nameOfDepartMent = listofEmployeeRecord.stream().map(ProblemWithEmployee::getDepartName).distinct().toList();
        System.out.println("Employee of name  :: " + nameOfDepartMent);

        //Q6 Average of male and female employee
        Map<String,Double> avergeOfEmployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.averagingInt(ProblemWithEmployee::getAge)));

        System.out.println(avergeOfEmployee);

        //Q7 .higest paied employee
        List<ProblemWithEmployee> higestpaiedemployeeDetails = listofEmployeeRecord
                .stream()
                .sorted(Comparator.comparing(ProblemWithEmployee::getSalary)
                        .reversed())
                .skip(0)
                .findFirst()
                .stream()
                .toList();
        System.out.println(higestpaiedemployeeDetails);

        //Q8. Print all employee after 2015 join
        List<String> printNameOfDetails = listofEmployeeRecord.stream().filter(i -> i.getYearOfJoining() > 2015).map(ProblemWithEmployee::getName).toList();

        System.out.println(printNameOfDetails);

        //Q.8 count the employee for each department
        Map<String,Long> countOfeachEmployeenamec = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.counting()));

        countOfeachEmployeenamec.forEach((dep,count) ->{
            System.out.println(dep + " " + count);
        });

        //Q 9 averge salary of each  department of employee
        Map<String,Double> avergaeOfEachemployee = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.averagingDouble(ProblemWithEmployee::getSalary)));
        avergaeOfEachemployee.forEach((dep,avgsal) ->{
            System.out.println(dep + " " + avgsal);
        });


        //Q.10 get the details of young employee male of finance department(Age)

        List<ProblemWithEmployee> yougestEmployeeOffiance = listofEmployeeRecord.stream().filter(o -> o.getGender() =="male" && o.getDepartName()=="finance").min(Comparator.comparingInt(ProblemWithEmployee::getAge)).stream().toList();
        System.out.println(yougestEmployeeOffiance);

        //Q.11 how many male and female employee for finance
        Map<String,Long> malefemaleEmployee = listofEmployeeRecord.stream().filter(i -> i.getDepartName() == "finance").collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.counting()));
        System.out.println(malefemaleEmployee);

        //Q.12
        //averge salary of male and female employee
        Map<String,Double> avergeSalaryOfmaleAndFemale = listofEmployeeRecord.stream().collect(Collectors.groupingBy(ProblemWithEmployee::getGender,Collectors.averagingDouble(ProblemWithEmployee::getSalary)));
        avergeSalaryOfmaleAndFemale.forEach((gender,avsal) -> {
            System.out.println(gender + " : " + avsal);
        });

        //Q 13 print the name of all department wise employe Name

        Map<String,List<String>> departmentwiseName = listofEmployeeRecord
                .stream()
                .collect(Collectors.groupingBy(ProblemWithEmployee::getDepartName,Collectors.mapping(ProblemWithEmployee::getName,Collectors.toList())));

        departmentwiseName.forEach((dep , nam) -> {
            System.out.println( dep + " : " + nam);
        });*/

    }
}

