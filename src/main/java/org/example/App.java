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
    public static void q1() {
        HashSet<BigDecimal> set = new HashSet<BigDecimal>();
        TreeSet<BigDecimal> treeSet = new TreeSet<BigDecimal>();

        set.add(new BigDecimal("1.0"));
        set.add(new BigDecimal("1.00"));
        set.add(new BigDecimal("1.000"));

        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));

        System.out.println(set.size());
        System.out.println(treeSet.size());
    }

    public static void q2() {
        List<String> list = new ArrayList<String>(Arrays.asList("qwerty", "dfasdfa", "dsa", "f", "asdfsdfa", "retwer"));
        List<String> list2 = list.stream()
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

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!");
        System.out.println("q1:");
        q1();
        System.out.println("ExceptionsSample:");
        ExceptionsSample exceptionsSample = new ExceptionsSample();
        System.out.println(exceptionsSample.calc(2, 2));
        System.out.println("q2:");
        q2();
    }
}
