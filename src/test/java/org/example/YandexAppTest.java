package org.example;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class YandexAppTest {

    @Test
    public void task1_v1SuccessTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 1, 2, 7, 3, 2};
        List<Integer> integerList = YandexApp.task1(arr1, arr2);
        Collections.sort(integerList);
        assertEquals(Arrays.asList(1, 2, 2, 3), integerList);
    }

    @Test
    public void task1_v1NoCrossElemFailTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 6, 7, 8, 9};
        List<Integer> integerList = YandexApp.task1(arr1, arr2);
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void task1_v2SuccessTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 1, 2, 7, 3, 2};
        List<Integer> integerList = YandexApp.task1_v2(arr1, arr2);
        Collections.sort(integerList);
        assertEquals(Arrays.asList(1, 2, 2, 3), integerList);
    }

    @Test
    public void task1_v2NoCrossElemFailTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 6, 7, 8, 9};
        List<Integer> integerList = YandexApp.task1_v2(arr1, arr2);
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void task1_v3SuccessTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 1, 2, 7, 3, 2};
        List<Integer> integerList = YandexApp.task1_v3(arr1, arr2);
        Collections.sort(integerList);
        assertEquals(Arrays.asList(1, 2, 2, 3), integerList);
    }

    @Test
    public void task1_v3NoCrossElemFailTest() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 2, 0};
        Integer[] arr2 = new Integer[]{5, 6, 7, 8, 9};
        List<Integer> integerList = YandexApp.task1_v3(arr1, arr2);
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void task2_RLETest() {
        final String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        assertEquals("A4B3C2XYZD4E3F3A6B28", YandexApp.task2_RLE(str));
    }

    @Test
    public void task2_RLE_v2Test() {
        final String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        assertEquals("A4B3C2XYZD4E3F3A6B28", YandexApp.task2_RLE_v2(str));
    }

    @Test
    public void getStringWithGroupedCharsTest() {
        final String str = "acbda";
        assertEquals("a2bcd", YandexApp.getStringWithGroupedChars(str));
    }

    @Test
    public void appenderInterfaceTest() {
        StringBuilder stringBuilder = new StringBuilder();
        YandexApp.Appender.append(stringBuilder, 1, 3);
        assertEquals("1-3", stringBuilder.toString());
        YandexApp.Appender.append(stringBuilder, 5, 5);
        assertEquals("1-3,5", stringBuilder.toString());
        YandexApp.Appender.append(stringBuilder, 6, 9);
        assertEquals("1-3,5,6-9", stringBuilder.toString());
    }

    @Test
    public void task3Test() {
        int[] arr = new int[]{1, 4, 5, 2, 3, 9, 8, 11, 0};
        assertEquals("0-5,8-9,11", YandexApp.task3(arr));
        arr = new int[]{1, 4, 3, 2};
        assertEquals("1-4", YandexApp.task3(arr));
        arr = new int[]{1, 4};
        assertEquals("1,4", YandexApp.task3(arr));
    }

    @Test
    public void task4Test() {
        int[] arr = new int[]{1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0};
        assertEquals(5, YandexApp.task4(arr));
        arr = new int[]{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0};
        assertEquals(9, YandexApp.task4(arr));
        arr = new int[]{1, 0, 1};
        assertEquals(2, YandexApp.task4(arr));
        arr = new int[]{1, 1};
        assertEquals(2, YandexApp.task4(arr));
        arr = new int[]{1, 0};
        assertEquals(1, YandexApp.task4(arr));
        arr = new int[]{1};
        assertEquals(1, YandexApp.task4(arr));
    }

    @Test
    public void task5Test() {
        final int[][] arr = new int[][]{{1, 3}, {3, 4}, {2, 3}, {2, 5}};
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(2, 3);
        final Optional<Map.Entry<Integer, Integer>> entryOpt = YandexApp.task5_getMaxGuests(arr);
        assertTrue(entryOpt.isPresent());
        assertEquals(map.entrySet().toArray()[0], entryOpt.get());
    }

    @Test
    public void task6Test() {
        final String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        final HashMap<String, Set<String>> expResult = new HashMap<>();
        expResult.put("aet", Stream.of("ate", "eat", "tea").collect(Collectors.toSet()));
        expResult.put("ant", Stream.of("nat", "tan").collect(Collectors.toSet()));
        expResult.put("abt", Stream.of("bat").collect(Collectors.toSet()));
        assertEquals(expResult, YandexApp.task6_getStringGroups(arr));
    }

    @Test
    public void task7Test() {
        final int[][] arr = new int[][]{{1, 3}, {100, 200}, {2, 4}};
        assertEquals(List.of(List.of(1, 4), List.of(100, 200)), YandexApp.task7_getMergedRanges(arr));
    }

    @Test
    public void task10Test() {
        final List<List<Integer>> ranges = List.of(List.of(1, -3, 4, 5), List.of(3, 7, 4, 4, 5));
        final int targetNum = 9;
        assertArrayEquals(new int[]{2, 3}, YandexApp.task10_getRange(ranges, targetNum));
    }

    @Test
    public void task10ThreadsTest() {
        final List<List<Integer>> ranges = List.of(List.of(1, -3, 5, 5), List.of(3, 7, 4, 7, 5), List.of(1, 7, 4, 1, 8));
        final int targetNum = 9;
        final int countThreads = 2;
        assertArrayEquals(new int[]{3, 4}, YandexApp.task10_getRange_Threads(ranges, targetNum, countThreads));
    }

    @Test
    public void task9Test() {
        assertTrue(YandexApp.task9_is_chg_first_str_to_second("abcde", "abzde"));
        assertTrue(YandexApp.task9_is_chg_first_str_to_second("acde", "abcde"));
        assertTrue(YandexApp.task9_is_chg_first_str_to_second("abcdeh", "abcde"));
        assertFalse(YandexApp.task9_is_chg_first_str_to_second("abqwe", "abcde"));
        Exception exception = assertThrows("Ожидалось исключение RuntimeException", RuntimeException.class,
                () -> {
                    YandexApp.task9_is_chg_first_str_to_second("abcdehh", "abcde");
                });
        assertEquals("Error! Strings differents more than one char", exception.getMessage());
    }
}
