package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NormalCodingJava {

    public static void main(String[] args) {

        //find the even and odd number
        List<Integer> numbers = Arrays.asList(12,22,55,77,88,45,69);
        List<Integer> evenNUmber = numbers.stream().filter(i -> i % 2 ==0).toList();
        System.out.println("Even number :: " +evenNUmber);

        //odd number of list
        List<Integer> oddNumber = numbers.stream().filter(o -> o%2!=0).toList();
        System.out.println("odd number  :: " +oddNumber);

        //finding even number using array
        int[] no = {12,22,55,77,88,45,69};
        int[] evenNumber = Arrays.stream(no).filter(i -> i%2==0).toArray();
        System.out.println("arrays even number :: " +Arrays.toString(evenNumber));

        //sum of even number
        Integer sumofEvenNumber = Arrays.stream(no).filter(p -> p%2==0).sum();
        System.out.println(sumofEvenNumber);

        //frequency of characters String
        String str = "dhhdaGGbbacABC";
        Map<Character,Long> countOfString = str.toLowerCase().chars().mapToObj( c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("count of string :: " +countOfString);

        //frequency count String format
        String frequencyCountStringFormat = countOfString
                .entrySet()
                .stream()
                .map(k -> k.getKey() + "" +k.getValue()).collect(Collectors.joining());
        System.out.println(frequencyCountStringFormat);

        //sorting Number of ArrayList
        List<Integer> num = Arrays.asList(58, 55, 42, 36, 30, 22, 88);
        List<Integer> ascedingNumber = num.stream().sorted().toList();
        System.out.println("AescNumberSortingList :: " +ascedingNumber);

        //descending number of list
        List<Integer> descNumberSortingList = num.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("descNumberSortingList :: " +descNumberSortingList);

        //print the second-highest number in Array of list
        List<Integer> n = Arrays.asList(58, 55, 42, 36, 30, 22, 88);
        Integer secondheighestNumber = n.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("second highest number:: " + secondheighestNumber);

        //Q17 Shifted in right side for zeros
        int[] arr = {3, 2, 0, 7, 0, 5, 6};

        List<Integer> non_value_list = Arrays.stream(arr).filter(i -> i!=0).boxed().collect(Collectors.toList());
        System.out.println(non_value_list);
        Long count = Arrays.stream(arr).filter(o -> o==0).count();

        for(int i = 0; i<count; i++){
            non_value_list.add(0);
        }
        System.out.println(non_value_list);

        //output in group of String of array [[eat, tea, ate], [pot, opt], [abc]] same string putting in one group
        String[] ar = {"eat", "tea", "abc", "pot", "opt", "ate"};
        Map<String,List<String>> sameStringinSamegroup = Arrays.stream(ar).collect(Collectors.groupingBy(i -> {
            char[] c = i.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        List<List<String>> output = new ArrayList<>(sameStringinSamegroup.values());
        System.out.println(output);

        //first non-repeted character using java 8 or basic java
        String input = "swiss";
        StringBuffer stringBuffer = new StringBuffer();
        Set<Character> checkcontaions = new HashSet<>();

       /* for(char c : input.toCharArray()){
            if(checkcontaions.contains(c)){
                break;
            }
            checkcontaions.add(c);
            stringBuffer.append(c);
        }
        System.out.println(stringBuffer);*/

        input.chars().mapToObj(c -> (char)c).forEach(u -> {
            if(!checkcontaions.contains(u)){
                checkcontaions.add(u);
                stringBuffer.append(u);
            }
        });

        System.out.println(stringBuffer);


        //write the program start with first character in upper and other as it is
        String[] name = {"java", "aws", "test", "pest"};
        List<String> upperCaseData = Arrays.stream(name).map(t -> t.substring(0,1).toUpperCase()+ ""+ t.substring(1)).toList();
        System.out.println(upperCaseData);

        //upper and lower case of string
        String str1 = "aBcD";
        String rs = str1.chars().mapToObj( c -> {
            char d = (char)c;
            return Character.isLowerCase(d) ? Character.toUpperCase(d) : Character.toLowerCase(d);
        }).map(String::valueOf).collect(Collectors.joining());
        System.out.println(rs);

        //Q.22 Maximum Subarray Problem
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxArray = nums[0];
        int currentMaxArra = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > currentMaxArra + nums[i]){
                currentMaxArra = nums[i];
            }else {
                currentMaxArra = currentMaxArra + nums[i];
            }
            if(currentMaxArra > maxArray){
                maxArray = currentMaxArra;
            }
        }
        System.out.println(maxArray);


        //write the code for power of 2 value true or false
        int nnom = 8;
        boolean status = false;

        status = (nnom & (nnom - 1))==0;
        System.out.println(status);

        //find the binary number from integer value
        int inputNumber = 15;
        int[] bytes = new int[60];
        int index =0;
        while (inputNumber > 0) {
            bytes[index]=inputNumber % 2;
            inputNumber = inputNumber / 2;
            index++;
        }
        for (int i = index -1; i>=0;i--){
            System.out.println(bytes[i]);
        }

        //merging two array
        int[] a = {1,5,8,9,6,7};
        int[] b = {2,3,5,6,7,9,4,5};

        List<Integer> mergarray = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).boxed().sorted(Comparator.reverseOrder()).distinct().toList();
        System.out.println(mergarray);

        //Q27 find the duplicate element in th list integer value
        List<Integer> values = Arrays.asList(4, 6, 5, 7, 4, 6, 9, 6, 7, 5,9,10);
        List<Integer> duplicate = values
                .stream()
                .collect(Collectors.groupingBy(i -> i , Collectors.counting())).entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(duplicate);


        //find the duplicate number in array list
        int[] d = {2,3,5,6,7,9,4,5};
        List<Integer> idup = Arrays.stream(d).boxed().collect(Collectors.groupingBy(i -> i ,Collectors.counting())).entrySet().stream().filter(u -> u.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(idup);

// Q.29 find the list of duplicate word
        List<String> words = Arrays.asList("test","pest","test","java","test","pest");
        List<String> duplicateWord = words.stream().filter( p -> Collections.frequency(words,p) > 1).distinct().toList();
        System.out.println(duplicateWord);

        // Q 30. seperate the integer / String values and String value
        String abc ="aabbc1123";
        String onlyString = abc.chars().mapToObj(o -> (char)o).filter(Character :: isAlphabetic).map(String::valueOf).collect(Collectors.joining());
        System.out.println(onlyString);

        String onlyNumber = abc.chars().mapToObj(y -> (char)y).filter(Character::isDigit).map(String::valueOf).collect(Collectors.joining());
        System.out.println(onlyNumber);

        //Q 31.find the top 3 highest salary in list
        List<Integer> topEmployeeNumber = Arrays.asList(500,400,300,100,200,700,1000,500);
        List<Integer> findOfTop3highestNumber = topEmployeeNumber.stream().limit(3).toList();
        System.out.println(findOfTop3highestNumber);

        //Q 32 remove the duplicate in string

        String duplicateString = "aabbccddeff";
        String removeDupliCate = duplicateString.toLowerCase().chars().mapToObj(c -> (char)c).map(String::valueOf).distinct().collect(Collectors.joining());
        System.out.println(removeDupliCate);

        //find the duplucate string
        String string = "aabbcddee";
        List<Character> dup = string
                .chars()
                .mapToObj(t -> (char)t)
                .collect(Collectors.groupingBy(i -> i , Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();



        //removeDuplicateelemnt
        int[] el = {7,5,4,3,8,5,2,1,4};
        List<Integer> re = Arrays.stream(el).boxed().distinct().toList();

        //prime number
        int number = 29;
        boolean staus = IntStream.rangeClosed(2,(int) Math.sqrt(number)).noneMatch(i -> number%i==0);

        System.out.println(staus);

        //missing array number find Particuler range
        int[] ar12 = {1,3,6,7,9,8,10};

        Set<Integer> set = Arrays.stream(ar12).boxed().collect(Collectors.toSet());

        int min = Arrays.stream(ar12).min().getAsInt();
        int max = Arrays.stream(ar12).max().getAsInt();

        List<Integer> missing = IntStream.rangeClosed(min, max)
                .filter(n1 -> !set.contains(n1))
                .boxed()
                .toList();
        System.out.println("Missing Arrays numbers: " + missing);


        //sum of single or multiple numbers
        System.out.println(sumOfMultipleNumber(5,5));

        //Subtract of numbers single and multiple numbers
        System.out.println(substractMethod(1,1));

        //decendingOrderOfProgram string of frequency sorting by value base
        String st = "aabbbccdeef";
        Map<Character,Long> freq = st.toLowerCase()
                .chars()
                .mapToObj(j -> (char)j)
                .collect(Collectors.groupingBy(y -> y ,Collectors.counting()));

        System.out.println(freq);

        freq.entrySet().stream()
                .sorted(Map.Entry.<Character,Long> comparingByValue().reversed()).forEach(i -> System.out.println(i.getKey() + ":" + i.getValue()));


        //String reverse program using java 8
        String s = "ravindra";







    }

    //Sum
    public static int sumOfMultipleNumber(int... numbers){

        return IntStream.of(numbers).sum();
    }
    //multiplying
    public static int substractMethod(int... nu){
        return IntStream.of(nu).reduce(1, (a,b) -> a * b);
    }
    //sunbsytract
}
