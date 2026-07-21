package com.project.springboot.CodingPracties;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NormalClass {
    public static void main(String[] args) {

        //find the even and odd number
        List<Integer> numbers = Arrays.asList(12,22,55,77,88,45,69);
        List<Integer> op = numbers.stream().filter(i -> i%2==0).toList();
        System.out.println(op);

        //frequency of characters String
        String str = "dhhhhhhhdaGGbbacABC";
        Map<Character,Long> freqCount = str.toLowerCase().chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        System.out.println(freqCount);

        //out freq output from string format
        String outPut = freqCount.entrySet().stream().map(i -> i.getKey()+""+i.getValue()).collect(Collectors.joining());
        System.out.println(outPut);

        //count wise decending output
        freqCount.entrySet().stream().sorted(Map.Entry.<Character,Long> comparingByValue().reversed()).forEach(i -> System.out.println(i.getKey() + ":" +i.getValue()));

        //print the second-highest number in Array of list
        List<Integer> n = Arrays.asList(58, 55, 42, 36, 30, 22, 88);
        Integer secondNumber = n.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondNumber);

        //Q17 Shifted in right side for zeros
        int[] arr = {3, 2, 0, 7, 0, 5, 6};
        List<Integer> findTheWithOutZeroValue = Arrays.stream(arr).filter(i -> i!=0).boxed().collect(Collectors.toList());
        Long countOfZero = Arrays.stream(arr).filter(j -> j==0).count();
        for(int i=0;i<countOfZero;i++){
            findTheWithOutZeroValue.add(0);
        }
        System.out.println(findTheWithOutZeroValue);

        //output in group of String of array [[eat, tea, ate], [pot, opt], [abc]] same string putting in one group
        String[] ar = {"eat", "tea", "abc", "pot", "opt", "ate"};
        Map<String,List<String>> groupOfData = Arrays.stream(ar).collect(Collectors.groupingBy(u -> {
            char[] c = u.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }));

        List<List<String>> resultData = new ArrayList(groupOfData.values());
        System.out.println(resultData);

        //write the program start with first character in upper and other as it is
        String[] name = {"java", "aws", "test", "pest"};
        List<String> firstCharacterValueUpperCase = Arrays.stream(name).map(i -> i.substring(0,1).toUpperCase() + "" + i.substring(1)).toList();
        System.out.println(firstCharacterValueUpperCase);


        //Q.22 Maximum Subarray Problem
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxArray = nums[0];
        int currentMaxArray = nums[0];

        for(int i = 1; i< nums.length;i++){
            if(nums[i] > currentMaxArray + nums[i]){
                currentMaxArray = nums[i];
            }else {
                currentMaxArray = currentMaxArray + nums[i];
            }

            if(currentMaxArray > maxArray){
                maxArray =currentMaxArray;
            }
        }
        System.out.println(maxArray);

        //merging two array
        int[] a = {1,5,8,9,6,7};
        int[] b = {2,3,5,6,7,9,4,5};

        List<Integer> mergeToArray = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).boxed().sorted(Comparator.reverseOrder()).distinct().toList();
        //System.out.println(Arrays.toString(mergeToArray));
        System.out.println(mergeToArray);


        //Q27 find the duplicate element in th list integer value
        List<Integer> values = Arrays.asList(4, 6, 5, 7, 4, 6, 9, 6, 7, 5,9,10);

        List<Integer> findTheDuplicateElement = values.stream().collect(Collectors.groupingBy(t -> t,Collectors.counting()))
                .entrySet().stream()
                .filter(i -> i.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(findTheDuplicateElement);

        List<String> words = Arrays.asList("test","pest","test","java","test","pest");

        List<String> duplicateWordInList = words.stream().filter(names -> Collections.frequency(words,names) > 1).distinct().toList();
        System.out.println(duplicateWordInList);







    }
}
