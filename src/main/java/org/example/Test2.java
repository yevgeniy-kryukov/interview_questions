package org.example;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Test2 {
    /**
     * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
     * Надо вернуть [1, 2, 2, 3] (порядок неважен)
     */
    private static List<Integer> getMatchingValues(int[] a1, int[] a2) {
        List<Integer> result = new ArrayList<>();
        int el1Count;
        int el2Count;
        for (int el : a1) {
            if (result.contains(el)) {
                continue;
            }
            el1Count = 0;
            el2Count = 0;
            for (int i = 0; i < Math.max(a1.length, a2.length); i++) {
                if (i < a1.length && el == a1[i]) {
                    el1Count++;
                }
                if (i < a2.length && el == a2[i]) {
                    el2Count++;
                }
            }
            if (el1Count == el2Count) {
                for (int j = 0; j < el1Count; j++) {
                    result.add(el);
                }
            }
        }
        return result;
    }

    /**
     * Дана строка acbda.
     * Написать функцию, которая вернет a2bcd.
     */
    public static String getStringWithGroupedChars(String str) {
        IntFunction<String> intFunction = p1 -> String.valueOf((char) p1);
        List<String> charsList = str.chars().mapToObj(intFunction).collect(Collectors.toList());
        Map<String, Long> mapCount = charsList.stream().collect(Collectors.groupingBy(el -> el, Collectors.counting()));
        return mapCount.entrySet().stream().collect(StringBuilder::new,
                (st, el) -> {
                    st.append(el.getKey());
                    if (el.getValue() > 1) {
                        st.append(el.getValue());
                    }
                },
                (st1, st2) -> st2.append(st1.toString())
        ).toString();
    }

    /**
     * Даны даты заезда и отъезда каждого гостя.
     * Для каждого гостя дата заезда строго раньше даты отъезда (то есть каждый гость останавливается хотя бы на одну ночь).
     * В пределах одного дня считается, что сначала старые гости выезжают, а затем въезжают новые.
     * Найти максимальное число постояльцев, которые одновременно проживали в гостинице
     * (считаем, что измерение количества постояльцев происходит в конце дня).
     * <p>
     * sample = [ (1, 2), (1, 3), (2, 4), (2, 3), ]
     */
    public static Optional<Map.Entry<Integer, Integer>> getMaxGuests(int[][] visits) {
        Map<Integer, Integer> countVisits = new HashMap<>();
        for (int[] el : visits) {
            for (int day = el[0]; day < el[1]; day++) {
                countVisits.put(day, countVisits.get(day) != null ? countVisits.get(day) + 1 : 1);
            }
        }
        return countVisits.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
    }

    /**
     * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
     * Sample Output [ ["ate", "eat", "tea"], ["nat", "tan"], ["bat"] ]
     * Т.е. сгруппировать слова по "общим буквам".
     */
    public static Map<String, Set<String>> getGroupedStrings(String[] arrStr) {
        Map<String, Set<String>> result = new HashMap<>();
        String elSorted;
        for (String el : arrStr) {
            elSorted = el.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            Set<String> stringSet = result.computeIfAbsent(elSorted, k -> new HashSet<>());
            stringSet.add(el);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] a1 = new int[]{1, 2, 3, 2, 0};
//        int[] a2 = new int[]{5, 1, 2, 7, 3, 2};
//        System.out.println(getMatchingValues(a1, a2));

        //System.out.println(getStringWithGroupedChars("abcac"));
        //System.out.println(getMaxGuests(new int[][]{{1, 3}, {3, 4}, {2, 3}, {2, 5}}));
        System.out.println(getGroupedStrings(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
