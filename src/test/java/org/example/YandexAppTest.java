package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class YandexAppTest {

    @Test
    public void task1SuccessTest() {
        int[] arr1 = new int[]{1, 2, 3, 2, 0};
        int[] arr2 = new int[]{5, 1, 2, 7, 3, 2};
        List<Integer> integerList = YandexApp.task1(arr1,arr2);
        Collections.sort(integerList);
        assertEquals(Arrays.asList(1, 2, 2, 3), integerList);
    }

    @Test
    public void task1NoCrossElemFailTest() {
        int[] arr1 = new int[]{1, 2, 3, 2, 0};
        int[] arr2 = new int[]{5, 6, 7, 8, 9};
        List<Integer> integerList = YandexApp.task1(arr1,arr2);
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void task1_v2SuccessTest() {
        int[] arr1 = new int[]{1, 2, 3, 2, 0};
        int[] arr2 = new int[]{5, 1, 2, 7, 3, 2};
        List<Integer> integerList = YandexApp.task1_v2(arr1,arr2);
        Collections.sort(integerList);
        assertEquals(Arrays.asList(1, 2, 2, 3), integerList);
    }

    @Test
    public void task1_v2NoCrossElemFailTest() {
        int[] arr1 = new int[]{1, 2, 3, 2, 0};
        int[] arr2 = new int[]{5, 6, 7, 8, 9};
        List<Integer> integerList = YandexApp.task1_v2(arr1,arr2);
        assertTrue(integerList.isEmpty());
    }
}
