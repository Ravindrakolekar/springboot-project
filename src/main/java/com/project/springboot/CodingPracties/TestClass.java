package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestClass {

    transient String password;

    public static void main(String[] args) {

        //find the even and odd number
        List<Integer> numbers = Arrays.asList(12,22,55,77,88,45,69);
        List<Integer> np = numbers.stream().filter(i -> i%2==0).toList();

        //frequency of characters String
        String str = "dhhhhhhhdaGGbbacABC";
        Map<Character,Long> frequency = str
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char)c).collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println(frequency);

        //output in String format
        String mapOutput = frequency.entrySet().stream().map(i -> i.getKey()+""+i.getValue()).collect(Collectors.joining());
        System.out.println(mapOutput);

        //decedning order call
        frequency.entrySet().stream().sorted(Map.Entry.<Character,Long> comparingByValue().reversed()).forEach(o -> System.out.println(o.getKey()+":"+o.getValue()));


        //print the second-highest number in Array of list
        List<Integer> n = Arrays.asList(58, 55, 42, 36, 30, 22, 88);
        Integer highestSecondNumber = n.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(highestSecondNumber);

        //Q17 Shifted in right side for zeros
        int[] arr = {3, 2, 0, 7, 0, 5, 6};
        List<Integer> findNonZeroValue = Arrays.stream(arr).filter(y -> y!=0).boxed().collect(Collectors.toList());
        System.out.println(findNonZeroValue);
        Long count = Arrays.stream(arr).filter(o -> o==0).count();
        System.out.println(count);
        for(int i =0; i < count; i++) {
            findNonZeroValue.add(0);
        }
        System.out.println(findNonZeroValue);

        //output in group of String of array [[eat, tea, ate], [pot, opt], [abc]] same string putting in one group
        String[] ar = {"eat", "tea", "abc", "pot", "opt", "ate"};
        Map<String,List<String>> groupingElement = Arrays.stream(ar).collect(Collectors.groupingBy(o -> {
            char[] c = o.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));
        List<List<String>> result = new ArrayList<>(groupingElement.values());
        System.out.println(result);

        //find first non repeted character
        String input = "swiss";


        //write the program start with first character in upper and other as it is
        String[] name = {"java", "aws", "test", "pest"};
        List<String> firstCharaterIsUpperCase = Arrays
                .stream(name)
                .map(y -> y.substring(0,1).toUpperCase()+""+y.substring(1)).toList();
        System.out.println(firstCharaterIsUpperCase);


        //upper and lower case of string
        String str1 = "aBcD";
        String upperToLowerCase = str1.chars().mapToObj(o -> {
            char c = (char)o;
            return Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }).map(String::valueOf).collect(Collectors.joining());

        System.out.println(upperToLowerCase);

        //Q.22 Maximum Subarray Problem
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxArray  = nums[0];
        int curreTArray = nums[0];

        for(int i = 1 ; i< nums.length;i++){
            if(nums[i] > curreTArray + nums[i]){
                curreTArray = nums[i];
            }else{
                curreTArray = curreTArray + nums[i];
            }
            if(curreTArray > maxArray){
                maxArray= curreTArray;
            }
            System.out.println(maxArray);
        }

        //merging two array
        int[] a = {1,5,8,9,6,7};
        int[] b = {2,3,5,6,7,9,4,5};

        List<Integer> mergingArray = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).boxed().sorted(Comparator.reverseOrder()).distinct().toList();
        System.out.println(mergingArray);

        //Q27 find the duplicate element in th list integer value
        List<Integer> values = Arrays.asList(4, 6, 5, 7, 4, 6, 9, 6, 7, 5,9,10);
        List<Integer> findTheDuplicateElement = values
                .stream()
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(findTheDuplicateElement);

        List<String> words = Arrays.asList("test","pest","test","java","test","pest");
        List<String> fndDuplicateWord = words
                .stream()
                .filter(names -> Collections.frequency(words,names) > 1).distinct().map(String::valueOf).toList();


        String abc ="aabbc1123";
        String intgerNumber = abc.chars().mapToObj(t -> (char)t)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(intgerNumber);

        //prime number
        int primeNumber = 11;

        boolean stausOfPrime = IntStream.rangeClosed(2,(int) Math.sqrt(primeNumber)).noneMatch(i -> primeNumber%i==0);
        System.out.println(stausOfPrime);

        //missing Array
        int[] at = {1,5,8,9,6,7};
        Set<Integer> contains = Arrays.stream(at).boxed().collect(Collectors.toSet());

        int min = Arrays.stream(at).min().getAsInt();
        int max = Arrays.stream(at).max().getAsInt();

        List<Integer> missingArray = IntStream.rangeClosed(min,max)
                .filter(i -> !contains.contains(i))
                .boxed()
                .toList();
        System.out.println(missingArray);

        //find the palidrome program
        String palidromeString = "madamfb";
        int paldirome = 121;
        String strsss = String.valueOf(paldirome);
        boolean palidromeStatus = IntStream
                .rangeClosed(0 ,strsss.length() / 2)
                .allMatch(i -> strsss.charAt(i) == strsss.charAt(strsss.length() - 1 - i));

        System.out.println(palidromeStatus ? "Palidrome" : "notPalidrome");



        //find first non repeted characters
        String findFirstNonRepetedString = "iLoveVimoIndia";
        Character findFirstNonRept = findFirstNonRepetedString.chars().mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(t -> t,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(o -> o.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if(findFirstNonRept!=null)
        {
            System.out.println(findFirstNonRept);
        }

        //find the unique String in java
        String str12 = "aabbccdef";
        Map<Character,Long> findTheUiqueValue = str12.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Character> uniqueCharacter = findTheUiqueValue.entrySet().stream()
                .filter(i -> i.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(uniqueCharacter);

        //find the duplicate integer numbers
        int[] nno = {1,3,5,7,8,9,3,7};
        List<Integer> findTheDuplcTae = Arrays.stream(nno).boxed().collect(Collectors.groupingBy(i -> i ,Collectors.counting()))
                .entrySet().stream().filter(p -> p.getValue() > 1)
                .map(i -> i.getKey())
                .toList();

        System.out.println(findTheDuplcTae);

        //find the lengthWise Sorting
        String stringInput = "i am Ravndra from xoriant";

        //same output length wise order sorting
        Arrays.stream(stringInput.split(" ")).sorted((e,r) -> Integer.compare(r.length(),e.length())).forEach(t -> System.out.println(t));

        //same output length wise order sorting
        List<String> sortingLengthWiseOrder = Arrays.stream(stringInput.split(" "))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
        System.out.println(sortingLengthWiseOrder);

        Optional optional = Optional.ofNullable(null);
        if(optional.isPresent()){
            System.out.println("ssfff");
        }

        //find the lengthWise Sorting
        String stringInput1 = "i am Ravndra from xoriant";

        Arrays.stream(stringInput1.split(" ")).sorted((d,e) -> Integer.compare(d.length(),e.length())).forEach(o -> System.out.println(o));

        //find the value for the only integer numbers and string also
        List<String> inputValue = Arrays.asList("rr","12","wwww","440","3344","eee","-1234");
        List<String> outPutFromData = inputValue.stream().filter(s -> s.matches("\\d+")).toList();
        System.out.println(outPutFromData);

        //find the frequence cnumber of list
        List<Integer> numbersData = Arrays.asList(44,555,333,222,8,66,545,555,333);
        Map<Integer,Long> countOfFrequency = numbersData.stream().collect(Collectors.groupingBy(i -> i , Collectors.counting()));
        System.out.println(countOfFrequency);

        //frequency count of value of integer
        int[] i = {44,555,333,222,8,66,545,555,333};
        Map<Integer,Long> coutOfNumbers = Arrays.stream(i).boxed().collect(Collectors.groupingBy(e -> e ,Collectors.counting()));
        System.out.println(coutOfNumbers);








       /* //frequency of characters String
        String str = "dhhdaGGbbaccccABC";
        Map<Character,Long> frequncyCharacterCount = str.toLowerCase().chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(frequncyCharacterCount);

        //output like string format
        String stringOutput = frequncyCharacterCount.entrySet().stream().map( i -> i.getKey()+ "" +i.getValue()).collect(Collectors.joining());
        System.out.println(stringOutput);

        //decending of order by value base
        frequncyCharacterCount.entrySet().stream().sorted(Map.Entry.<Character,Long> comparingByValue().reversed()).forEach(i -> System.out.println(i.getKey() + "" +i.getValue()));

        String[] ar = {"eat", "tea", "abc", "pot", "opt", "ate"};
        Map<String,List<String>> groupingElemnt = Arrays.stream(ar).collect(Collectors.groupingBy(o -> {
            char[] c = o.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        List<List<String>> resultData = new ArrayList<>(groupingElemnt.values());
        System.out.println(resultData);

        //find the first non repeted characters
        String findFirstNonRepetedString = "iLoveVimoIndia";
        Character findFirstNonRept = findFirstNonRepetedString.chars().mapToObj(i -> (char)i)
                .collect(Collectors.groupingBy(t -> t,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(o -> o.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if(findFirstNonRept!=null)
        {
            System.out.println(findFirstNonRept);
        }

        //
        //write the program start with first character in upper and other as it is
        String[] name = {"java", "aws", "test", "pest"};
        List<String> startWithUpperCase = Arrays.stream(name).
                map(o -> o.substring(0,1).toUpperCase() + "" +o.substring(1)).toList();
        System.out.println(startWithUpperCase);

        //Q27 find the duplicate element in th list integer value
        List<Integer> values = Arrays.asList(4, 6, 5, 7, 4, 6, 9, 6, 7, 5,9,10);
        List<Integer> duplicateElemtn = values.stream().collect(Collectors.groupingBy(i -> i ,Collectors.counting())).entrySet()
                .stream().filter(y -> y.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(duplicateElemtn);

        // Q 30. seperate the integer / String values and String value
        String abc ="aabbc1123";
        String onlyDigitNumber = abc.chars().mapToObj(o -> (char)o).filter(Character::isDigit).map(String::valueOf).collect(Collectors.joining());
        System.out.println(onlyDigitNumber);


        //missing array number find Particuler range
        int[] ar12 = {1,3,6,7,9,8,10};

        Set<Integer> contains = Arrays.stream(ar12).boxed().collect(Collectors.toSet());
        Integer minNumber = Arrays.stream(ar12).min().getAsInt();
        Integer maxNumber = Arrays.stream(ar12).max().getAsInt();

        List<Integer> listOfmissingNumber = IntStream.rangeClosed(minNumber,maxNumber).filter(o -> !contains.contains(o)).boxed().toList();
        System.out.println(listOfmissingNumber);
*/


    }
}
