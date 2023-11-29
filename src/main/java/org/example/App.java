package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void q1_setsBigDecimal() {
        HashSet<BigDecimal> set = new HashSet<BigDecimal>();
        TreeSet<BigDecimal> treeSet = new TreeSet<BigDecimal>();

        set.add(new BigDecimal("1.0"));
        set.add(new BigDecimal("1.00"));
        set.add(new BigDecimal("1.00"));
        set.add(new BigDecimal("1.000"));

        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));
        treeSet.add(new BigDecimal("1.000"));

        System.out.println(set.size());
        System.out.println(treeSet.size());
    }

    public static void q2_sortByStrLen() {
        List<String> list = new ArrayList<String>(Arrays.asList("qwerty", "dfasdfa", "dsa", "f", "asdfsdfa", "retwer")); // new modified list
        List<String> list2 = list.stream() // new modified list
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list2);
    }

    public static void q3_sortByStrAlfReverse() {
        List<String> list = Arrays.asList("qwerty", "dfasdfa", "dsa", "f", "asdfsdfa", "retwer"); // new unmodified list
        List<String> list2 = list.stream() // new modified list
                .sorted(Comparator.reverseOrder())
                .collect(ArrayList<String>::new,
                        (listNew, item) -> listNew.add(item + 1),
                        (listNew, listAdd) -> listNew.addAll(listAdd)
                );
        System.out.println(list2);
    }

    public static void q4_getMaxNum() {
        int[] nums = new int[]{12, 3, 54, 66, 3, 34};
        int max = 0;
        for (int item : nums) {
            if (item > max) {
                max = item;
            }
        }
        System.out.println(max);
    }

    public static void q4_getMaxNumByStream() {
        int[] nums = new int[]{12, 3, 54, 66, 3, 34};
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(max);
    }

    public static void q5_getMinNum() {
        int[] nums = new int[]{12, 3, 54, 66, 3, 34};
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println(min);
    }

    public static void q5_getMinNumByStream() {
        int[] nums = new int[]{12, 3, 54, 66, 3, 34};
        int min = Arrays.stream(nums).min().getAsInt();
        System.out.println(min);
    }

    public static void q6_arrayListVsHashSet() {
        // List
        List<Integer> integerList = Arrays.asList(null, 12, 3, 54, 66, 3, 34, null);
        System.out.println("list: " + integerList);
        // List access by index
        System.out.println("List access by index 1:" + integerList.get(1));
        // Saved sorted list
        System.out.print("Saved ordered list: ");
        for (Integer item : integerList) {
            System.out.print(item + ", ");
        }

        System.out.println("\n=============");

        // HashSet
        HashSet<Integer> integerHashSet = new HashSet<>(integerList);
        // Not saved order HashSet without duplicates
        System.out.print("Not saved order HashSet without duplicates: ");
        for (Integer item : integerHashSet) {
            System.out.print(item + ", ");
        }
        System.out.println(" ");
    }

    public static void q7_sortStrByCountChr(List<String> stringList, char ch) {
        List<String> resultList = stringList.stream().sorted(
                (o1, o2) -> (int) ((o2.chars().filter(el -> el == ch).count() - o1.chars().filter(el -> el == ch).count()))
        ).collect(Collectors.toList());

        System.out.println(resultList);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        System.out.println("_______q1_setsBigDecimal:");
        q1_setsBigDecimal();
        System.out.println("_______ExceptionsSample:");
        ExceptionsSample exceptionsSample = new ExceptionsSample();
        System.out.println(exceptionsSample.run());
        System.out.println("_______q2_sortByStrLen:");
        q2_sortByStrLen();
        System.out.println("_______q3_sortByStrAlfReverse:");
        q3_sortByStrAlfReverse();
        System.out.println("_______q4_getMaxNum:");
        q4_getMaxNum();
        System.out.println("_______q4_getMaxNumByStream:");
        q4_getMaxNumByStream();
        System.out.println("_______q5_getMinNum:");
        q5_getMinNum();
        System.out.println("_______q5_getMinNumByStream:");
        q5_getMinNumByStream();
        System.out.println("_______q6_arrayListVsHashSet:");
        q6_arrayListVsHashSet();
        System.out.println("_______q7_sortStrByCountChr:");
        q7_sortStrByCountChr(Arrays.asList("fdgsdfg", "retretw", "rtqwwsads", "vxcbxc", "sfdwww"), 'w');

        //String pool example
        System.out.println("String pool example");
        String cat = new String("cat"); // Create object in heap space
        String cat1 = cat.intern();                    // Create object in pool string
        String cat2 = "cat";                   // get or create object from pool string
        String cat3 = "cat";                   // get or create object from pool string
        System.out.println(cat == cat1);
        System.out.println(cat2 == cat1);
        System.out.println(cat3 == cat2);

        String cat0 = new String("cat"); // Create object in heap space
        System.out.println(cat0 == cat1);

    }
}
