package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodigRevisionClass {
    int id;
    String name;
    String department;
    double salary;


    public CodigRevisionClass(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CodigRevisionClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

        List<CodigRevisionClass> listofRecord = new ArrayList<>();
        listofRecord.add(new CodigRevisionClass(1, "Ravindra", "HR", 100));
        listofRecord.add(new CodigRevisionClass(2, "vaibhav", "finance", 200));
        listofRecord.add(new CodigRevisionClass(3, "Kumar", "HR", 500));
        listofRecord.add(new CodigRevisionClass(4, "Ram", "finance", 300));
        listofRecord.add(new CodigRevisionClass(5, "Mahesh", "Wipro", 700));

        //highest third salary

        List<String> sal = listofRecord.stream().sorted(Comparator.comparing(CodigRevisionClass::getSalary).reversed()).map(CodigRevisionClass::getName).skip(2).findFirst().stream().toList();
        System.out.println(sal);

        //find department wise name list

        Map<String,List<String>> listOfDepartName = listofRecord.stream().collect(Collectors.groupingBy(CodigRevisionClass::getDepartment,Collectors.mapping(CodigRevisionClass::getName,Collectors.toList())));
        listOfDepartName.forEach((dep,emp) ->{
            System.out.println(dep + " " + emp);
        });


        //Q1 department wise emp name print
        Map<String, List<String>> departMentWiseEmployee = listofRecord.stream()
                .collect(Collectors.groupingBy(CodigRevisionClass::getDepartment, Collectors.mapping(CodigRevisionClass::getName, Collectors.toList())));

        departMentWiseEmployee.forEach((Dep, Emp) -> {
            System.out.println(Dep + " " + Emp);
        });

        //Q2 showing below salary name

        List<String> listOfEmplNamebelowSalary = listofRecord.stream()
                .filter(o -> o.getSalary() > 200)
                .map(CodigRevisionClass::getName)
                .map(String::toUpperCase)
                .toList();
        System.out.println("Employee Name :: " + listOfEmplNamebelowSalary);

        //Q3 showing below salary 500
        List<String> belowSalary = listofRecord.stream().filter(p -> p.getSalary() < 500).map(l -> l.getName()).toList();

        //Q4  find the even and odd number
        List<Integer> numbers = Arrays.asList(12, 58, 36, 78, 63, 99);
        List<Integer> evenNumber = numbers.stream().filter(o -> o % 2 == 0).toList();
        System.out.println(evenNumber);

        //Q5 odd number finding in list
        List<Integer> oddNumber = numbers.stream().filter(i -> i % 2 != 0).toList();
        System.out.println(oddNumber);

        //Q6 Using Array even number
        int[] a = {12, 58, 36, 78, 63, 99};
        int[] evnNumberWithArray = Arrays.stream(a).filter(o -> o % 2 == 0).toArray();
        System.out.println("Even Number with Normal Array :: " + Arrays.toString(evnNumberWithArray));

        //Q7 using Array with odd number
        int[] oddNumberWitharray = Arrays.stream(a).filter(p -> p % 2 != 0).toArray();
        System.out.println("Odd Number with Normal Array :: " + Arrays.toString(oddNumberWitharray));

        //Q8 sum and number using Array
        Integer sumOfCount = Arrays.stream(a).filter(o -> o % 2 == 0).sum();
        System.out.println("some of even number :: " + sumOfCount);


        //Q9 Frequency of every character
        String str = "dhhdaGGbbacABC";
        Map<Character, Long> freqNumber = str.toLowerCase().chars().mapToObj(y -> (char) y).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("count of freq Number :: " + freqNumber);

        //Q10 freq count in String format
        freqNumber.entrySet().stream().map(o -> o.getKey() + "" + o.getValue()).collect(Collectors.joining());

        //Q11 Ascending Number of ArrayList
        List<Integer> num = Arrays.asList(58, 55, 42, 36, 30, 22, 88);
        List<Integer> assSorting = num.stream().sorted().toList();
        System.out.println("Sorting of array :: " + assSorting);

        //Q12 Decending number of array list
        List<Integer> decNumberSorting = num.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Desc Sorting of array :: " + decNumberSorting);

        //Q13 employee salary wise Sorting ASC
        List<String> sortingofsalaryBase = listofRecord.stream().sorted(Comparator.comparing(CodigRevisionClass::getSalary)).map(CodigRevisionClass::getName).toList();
        System.out.println("salary wise Sorting ASC :: " + sortingofsalaryBase);

        //Q14 employee salary wise Sorting DESC //only print the name
        List<String> descOrderEmployeeSalarywise = listofRecord.stream().sorted(Comparator.comparing(CodigRevisionClass::getSalary).reversed()).map(CodigRevisionClass::getName).toList();
        System.out.println("salary wise Sorting DESC :: " + descOrderEmployeeSalarywise);

        //Q15 employee salary wise Sorting ASC  // Print the all details
        List<CodigRevisionClass> salarywisePrintThealldetails = listofRecord.stream().sorted(Comparator.comparing(CodigRevisionClass::getSalary)).toList();
        System.out.println("salary wise Sorting DESC with all details :: " + salarywisePrintThealldetails);

        //Q16 print the second-highest number in Array of list
        List<Integer> n = Arrays.asList(12, 88, 66, 99, 15, 63, 22);
        Integer secondHighestNum = n.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second highest number in list of arrays :: " + secondHighestNum);

        //Q17 Shifted in right side for zeros
        int[] arr = {3, 2, 0, 7, 0, 5, 6};

        List<Integer> firstGettingNonZeroValue = Arrays.stream(arr).filter(o -> o != 0).boxed().collect(Collectors.toList());

        Long count = Arrays.stream(arr).filter(p -> p == 0).count();

        for (int i = 0; i < count; i++) {

            firstGettingNonZeroValue.add(0);
        }

        System.out.println("Shifting in right side zero value :: " + firstGettingNonZeroValue);

        //Q18 output in group of string of array [[eat, tea, ate], [pot, opt], [abc]]
        String[] ar = {"eat", "tea", "abc", "pot", "opt", "ate"};

        Map<String, List<String>> groupOfDatainarray = Arrays.stream(ar).collect(Collectors.groupingBy(o -> {
            char[] c = o.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        List<List<String>> output = new ArrayList<>(groupOfDatainarray.values());
        System.out.println("group of data :: " + output);

        //Q19 //output like ="abc" first character is duplicate in string then skip all character after duplicate to end of String first non reeated
        String input = "swiss"; //swiss // abcdeafv
        StringBuffer stringBuffer = new StringBuffer();
        Set<Character> characterCheck = new HashSet();

        for (char c : input.toCharArray()) {
            if (characterCheck.contains(c)) {
                break;
            }
            characterCheck.add(c);
            stringBuffer.append(c);

        }
        System.out.println("first character is duplicate in string then skip all character after duplicate to end of String ::  " + stringBuffer);

        //Q20 write the program start with first character in upper and other as it is
        String[] name = {"java", "aws", "test", "pest"};

        List<String> firstCharacterIUpper = Arrays.stream(name).map(p -> p.substring(0, 1).toUpperCase() + "" + p.substring(1)).toList();
        System.out.println(firstCharacterIUpper);

        //Q.21 write the program lower case capital and upper case in lower case
        String string = "aBcD";
        String result = string.chars().mapToObj(p -> {
            char c = (char) p;
            return Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }).map(String::valueOf).collect(Collectors.joining());

        System.out.println("upper and lower case ::  " + result);

        //Q.22 Maximum Subarray Problem
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxArray = nums[0];
        int currentMaxArray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentMaxArray + nums[i]) {
                currentMaxArray = nums[i];
            } else {
                currentMaxArray = currentMaxArray + nums[i];
            }

            if (currentMaxArray > maxArray) {
                maxArray = currentMaxArray;
            }

        }
        System.out.println("maxmium subarray :: " + maxArray);

        //Q.23 write the code for power of 2 value true or false

        int number = 16;
        boolean status = false;

        status = (number & (number - 1)) == 0;
        System.out.println("Power of two :: " + status);

        //Q.24 write the input from integer value and output from binary
        int inputnumber = 15;

        int[] byts = new int[64];
        int index = 0;

        while (inputnumber > 0) {
            byts[index] = inputnumber % 2;
            inputnumber = inputnumber / 2;
            index++;
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.println(byts[i]);
        }

        //Q.25 write the number integer array following the condition : immediate left neighbor of the number is smaller and  immediate right neighbor of the number is higher
        //identify the print the all number
        int[] ar1 = {1, 3, 3, 6, 6, 7, 9, 0}; // 0,1,3,4,7,9

        System.out.println("Print the number of identify the all number :: ");
        for (int i = 1; i < ar1.length; i++) {
            if (ar1[i - 1] < ar1[i] && ar1[i] < ar1[i + 1]) {
                System.out.println(ar1[i]);
            }
        }

        //Q26 Two array merging
        int[] m1 = {1, 3, 3, 6, 6, 7, 9, 0};
        int[] m2 = {5, 7, 8, 5, 4, 3};

        int[] mergingTwoArray = IntStream.concat(Arrays.stream(m1), Arrays.stream(m2)).toArray();
        System.out.println("Merging Two arrays " + Arrays.toString(mergingTwoArray));


        //concurret hasmap example
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "abc");
        hashMap.put(2, "test");

        Iterator<Integer> it = hashMap.keySet().iterator();
        /*while (it.hasNext()){
           Integer key = it.next();
            System.out.println("Key: " + key);
           // System.out.println(it.hasNext());
            hashMap.put(3,"rrrr");
        }*/

        //way of hashmap traversing element
        Map<Integer, String> has = new HashMap<>();
        has.put(1, "aba");
        has.put(2, "test");
        has.put(3, "pest");

        //1 way traversing
        for (Map.Entry<Integer, String> entry : has.entrySet()) {

            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key :" + key + "Value : " + value);
        }

        // 2 way to traverssing with key and value
        for (Integer in : has.keySet()) {
            System.out.println(in);
        }

        // foreach with stream api
        has.entrySet().stream().forEach(r -> System.out.println(r.getKey() + " " + r.getValue()));

        // with lambda
        has.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        //Q27 find the duplicate element in th list integer value

        List<Integer> values = Arrays.asList(4, 6, 5, 7, 4, 6, 9, 6, 7, 5);
        List<Integer> findTheDuplicateElement = values.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(p -> p.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("Duplicate element find value :: " + findTheDuplicateElement);

        //Q 28find the duplicate in array normal Integer array number
        int[] c = {4, 44, 44, 55, 66, 999};
        List<Integer> dp = IntStream.of(c).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(o -> o.getKey() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(" :: " + dp);

        // Q.29 find the list of duplicate word
        List<String> words = Arrays.asList("test","pest","test","java","test");
        List<String> duplicateWord = words.stream().filter(names -> Collections.frequency(words,names) > 1).distinct().collect(Collectors.toList());
        System.out.println("Duplicate String word :: :  " + duplicateWord);

        // Q 30. seperate the integer / String values and String value
        String abc ="aabbc1123";
        String  numberseperate= abc.chars().mapToObj(y -> (char)y).filter(Character::isDigit).map(String::valueOf).collect(Collectors.joining());


        String seprateStringValue = abc.chars().mapToObj(v -> (char)v).filter(Character::isAlphabetic).map(String::valueOf).collect(Collectors.joining());

        System.out.println("Number seperate value :: " +numberseperate);
        System.out.println("seperate value for alphabet " +seprateStringValue);

        //Q 31.find the top 3 highest salary in list
        List<Integer> topEmployeeNumber = Arrays.asList(500,400,300,100,200,700,1000,500);
        List<Integer> findTheTopThreeHighestSalary = topEmployeeNumber.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("find the top 3 salary :: " + findTheTopThreeHighestSalary);

        //Q 32 remove the duplicate in string

        String duplicateString = "aabbccddeff";
        String removeDuplicateString = duplicateString.toLowerCase()
                .chars()
                .mapToObj(r -> String.valueOf((char)r))
                .distinct()
                .collect(Collectors.joining());
        System.out.println("Duplicate string remove :: " + removeDuplicateString);

        // Q 33 remove the duplicate element in array

        int[] el = {7,5,4,3,8,5,2,1,4};
        List<Integer> redparray = Arrays.stream(el).boxed().distinct().toList();
        System.out.println("remove the duplicate element value :: " + redparray);

        // find the duplicate value in int array
        int[] b = {4,4,5,6,7,5,8,9};
        List<Integer> duplicate = Arrays.stream(b)
                .boxed()
                .collect(Collectors.groupingBy(y -> y,Collectors.counting()))
                .entrySet().stream().filter(o -> o.getValue() > 1).map(Map.Entry ::getKey).collect(Collectors.toList());

        System.out.println("duplicate the find the array :: " + duplicate);

        //duplicate removed in list

        List<Integer> ls = Arrays.asList(45,66,96,88,66,88,45);
        List<Integer> rs = ls.stream().distinct().toList();
        System.out.println("remove duplicate element is list :: " + rs);

        //sequactial and flapmap stream

        List<List<String>> flatmap = Arrays.asList(Arrays.asList("Test","Pest"),Arrays.asList("OOO","UU"));

        List<String> flatmapOut = flatmap.stream().flatMap(List::stream).collect(Collectors.toList());

        // Stream and parallel stream example

        List<Integer> intvalue = Arrays.asList(2,4,5,6,9,8,9);
        List<Integer> opp = intvalue.stream().map(o -> o*2).toList();
        System.out.println(opp);

        List<Integer> opp1 = intvalue.parallelStream().map(o -> o*2).toList();
        System.out.println(opp1);

    }
}
