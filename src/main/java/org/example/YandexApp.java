package org.example;

import java.sql.Timestamp;
import java.util.*;

public class YandexApp {
    /**
     * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
     * Надо вернуть [1, 2, 2, 3] (порядок неважен)
     */
    public static List<Integer> task1(int[] a1, int[] a2) {
        List<Integer> arr3 = new ArrayList<>();

        HashMap<Integer, Integer> hashMap1 = Arrays.stream(a1).collect(HashMap::new,
                (map, item) -> {
                    Integer val = map.get(item);
                    map.put(item, val == null ? 1 : val + 1);
                },
                (map1, map2) -> map1.putAll(map2));

        HashMap<Integer, Integer> hashMap2 = Arrays.stream(a2).collect(HashMap::new,
                (map, item) -> {
                    Integer val = map.get(item);
                    map.put(item, val == null ? 1 : val + 1);
                },
                (map1, map2) -> map1.putAll(map2));

        for (Integer key : hashMap1.keySet()) {
            Integer val2 = hashMap2.get(key);
            if (val2 != null) {
                Integer val1 = hashMap1.get(key);
                if (val2.equals(val1)) {
                    for (int i = 0; i < val1; i++) {
                        arr3.add(key);
                    }
                }
            }
        }

        System.out.println(arr3);
        return arr3;
    }

    private static Integer[][] getGroupingElems(int[] arr1) {
        Integer[][] tmp_arr1 = new Integer[2][arr1.length];
        boolean found;
        int insIndex = 0;
        for (int k : arr1) {
            found = false;
            for (int j = 0; j < tmp_arr1[0].length; j++) {
                if (tmp_arr1[0][j] == null) {
                    break;
                }
                if (tmp_arr1[0][j] == k) {
                    tmp_arr1[1][j] = tmp_arr1[1][j] + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                tmp_arr1[0][insIndex] = k;
                tmp_arr1[1][insIndex] = 1;
                insIndex++;
            }
        }
        return tmp_arr1;
    }

    /**
     * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
     * Надо вернуть [1, 2, 2, 3] (порядок неважен)
     */
    public static List<Integer> task1_v2(int[] arr1, int[] arr2) {
        List<Integer> arr3 = new ArrayList<>();

        Integer[][] tmp_arr1 = getGroupingElems(arr1);
        Integer[][] tmp_arr2 = getGroupingElems(arr2);

        for (int i = 0; i < tmp_arr1[0].length; i++) {
            for (int j = 0; j < tmp_arr2[0].length; j++) {
                if (tmp_arr1[0][i] == null || tmp_arr2[0][j] == null) {
                    continue;
                }
                if ((tmp_arr1[0][i].equals(tmp_arr2[0][j])) && (tmp_arr1[1][i].equals(tmp_arr2[1][j]))) {
                    for (int z = 0; z < tmp_arr2[1][j]; z++) {
                        arr3.add(tmp_arr2[0][j]);
                    }
                }
            }
        }

        System.out.println(arr3);
        return arr3;
    }

    /**
     * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
     * Надо вернуть [1, 2, 2, 3] (порядок неважен)
     */
    public static List<Integer> task1_v3(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();
        int elCount1;
        int elCount2;
        for (int el : arr1) {
            if (resultList.contains(el)) {
                continue;
            }
            elCount1 = 0;
            elCount2 = 0;
            for (int j = 0; j < Math.max(arr1.length, arr2.length); j++) {
                if ((j < arr1.length) && (arr1[j] == el)) {
                    elCount1++;
                }

                if ((j < arr2.length) && (arr2[j] == el)) {
                    elCount2++;
                }
            }
            if (elCount1 == elCount2) {
                for (int n = 0; n < elCount1; n++) {
                    resultList.add(el);
                }
            }
        }
        return resultList;
    }

    private static int[] fillArrRand(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    interface ConditionAppend {
        StringBuilder append(StringBuilder sb, int count, char ch);
    }

    /**
     * Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
     * Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
     * И сгенерирует ошибку, если на вход пришла невалидная строка.
     * Пояснения: Если символ встречается 1 раз, он остается без изменений; Если символ повторяется более 1 раза, к нему добавляется количество повторений.
     */
    public static String task2_RLE(String str) {
        //AABB
        ConditionAppend conditionAppend = (sb, count, ch) -> {
            sb.append(ch);
            if (count > 1) {
                sb.append(count);
            }
            return sb;
        };
        StringBuilder result = new StringBuilder();
        if (str.isEmpty()) {
            throw new RuntimeException("Error! Input string is empty");
        }
        char currChar = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (currChar != str.charAt(i)) {
                result = conditionAppend.append(result, count, currChar);
                currChar = str.charAt(i);
                count = 0;
            }
            count++;
            if ((i + 1) == str.length()) {
                result = conditionAppend.append(result, count, currChar);
            }
        }
        return result.toString();
    }

    /**
     * Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
     * Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
     * И сгенерирует ошибку, если на вход пришла невалидная строка.
     * Пояснения: Если символ встречается 1 раз, он остается без изменений; Если символ повторяется более 1 раза, к нему добавляется количество повторений.
     */
    public static String task2_RLE_v2(String str) {
        final char specChar = ' ';
        StringBuilder result = new StringBuilder();
        if (str.isEmpty()) {
            throw new RuntimeException("Error! Input string is empty");
        }
        if (str.contains(String.valueOf(specChar))) {
            throw new RuntimeException("Error! String contains spec char");
        }
        str = str + specChar;
        char currChar = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (currChar != str.charAt(i)) {
                result.append(currChar);
                if (count > 1) {
                    result.append(count);
                }
                currChar = str.charAt(i);
                if (currChar == specChar) {
                    break;
                }
                count = 0;
            }
            count++;
        }
        return result.toString();
    }

    public static String getCountRepeatChars(String str) {
        Map<String, Integer> resHashMap = new HashMap<>();
        String chr = "";
        for (int i = 0; i < str.length(); i++) {
            chr = String.valueOf(str.charAt(i));
            resHashMap.put(chr, resHashMap.get(chr) != null ? resHashMap.get(chr) + 1 : 1);
        }
        return resHashMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(StringBuilder::new,
                        (sb, e) -> sb.append(e.getKey()).append(e.getValue()),
                        (sb1, sb2) -> sb1.append(sb2.toString())).toString();
    }

    interface Appender {
        static void append(StringBuilder str, int begin, int end) {
            if (str.length() > 0) {
                str.append(',');
            }
            str.append(begin);
            if (end > begin) {
                str.append('-').append(end);
            }
        }

        ;
    }

    /**
     * Дан список интов, повторяющихся элементов в списке нет.
     * Нужно преобразовать это множество в строку, сворачивая соседние по числовому ряду числа в диапазоны.
     * Примеры:
     * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
     * [1,4,3,2] => "1-4"
     * [1,4] => "1,4"
     */
    public static String task3(int[] arr) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(arr);
        int begin = arr[0];
        int end = arr[0];
        int delta;
        for (int j : arr) {
            delta = j - end;
            if (delta == 1) {
                end = j;
            } else if (delta > 1) {
                Appender.append(result, begin, end);
                begin = j;
                end = j;
            }
            if (j == arr[arr.length - 1]) {
                Appender.append(result, begin, end);
            }
        }
        return result.toString();
    }

    /**
     * Дан массив из нулей и единиц.
     * Нужно определить, какой максимальный по длине подинтервал единиц можно получить,
     * удалив ровно один элемент массива.
     * [1, 1, 0]
     */
    public static int task4(int[] arr) {
        int result = 1;
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == 1) {
                    count++;
                } else {
                    if (count > result) {
                        result = count;
                    }
                    count = 0;
                }
            }
            if (count > result) {
                result = count;
            }
            count = 0;
        }
        return result;
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
    public static Optional<Map.Entry<Integer, Integer>> task5_getMaxGuests(int[][] arrDts) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] el : arrDts) {
            for (int x = el[0]; x < el[1]; x++) {
                hashMap.put(x, hashMap.get(x) != null ? hashMap.get(x) + 1 : 1);
            }
        }
        return hashMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
    }

    /**
     * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
     * Sample Output [ ["ate", "eat", "tea"], ["nat", "tan"], ["bat"] ]
     * Т.е. сгруппировать слова по "общим буквам".
     */
    public static HashMap<String, HashSet<String>> task6_getStringGroups(String[] arr) {
        HashMap<String, HashSet<String>> result = new HashMap<>();
        String elSorted;
        for (String el : arr) {
            elSorted = el.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
//            HashSet<String> hashSet = result.get(elSorted);
//            if (hashSet == null) {
//                hashSet = new HashSet<>();
//                result.put(elSorted, hashSet);
//            }
            HashSet<String> hashSet = result.computeIfAbsent(elSorted, k -> new HashSet<>());
            hashSet.add(el);
        }
        return result;
    }

    /**
     * Слияние отрезков:
     * Вход: [1, 3] [100, 200] [2, 4]
     * Выход: [1, 4] [100, 200]
     */
    public static List<List<Integer>> task7_getMergedRanges(int[][] ranges) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> arr_tmp = new ArrayList<>();

        for (int[] range : ranges) {
            for (int j = range[0]; j <= range[1]; j++) {
                arr_tmp.add(j);
            }
        }

        Collections.sort(arr_tmp);

        int prev = arr_tmp.get(0);
        int delta;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr_tmp.size(); i++) {
            delta = arr_tmp.get(i) - prev;
            if (i == 0 || delta > 1) {
                if (delta > 1) {
                    list = new ArrayList<>();
                }
                list.add(arr_tmp.get(i));
                list.add(arr_tmp.get(i));
                result.add(list);
            }
            if (i > 0 && delta == 1) {
                list.set(1, arr_tmp.get(i));
            }
            prev = arr_tmp.get(i);
        }

        return result;
    }

    private static int[] getRange(List<Integer> range, int targetNum) {
        int[] result = new int[2];
        for (int i = 0; i < range.size() - 1; i++) {
            if ((range.get(i) + range.get(i + 1)) == targetNum) {
                result[0] = range.get(i);
                result[1] = range.get(i + 1);
                break;
            }
        }
        return result;
    }

    /**
     * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
     * elements = [1, -3, 4, 5]
     * target = 9
     * result = range(2, 4) # because elements[2] + elements[3] == target
     */
    public static int[] task10_getRange(List<List<Integer>> ranges, int targetNum) {
        int[] result = new int[2];
        for (List<Integer> range : ranges) {
            if (range.size() < 2) {
                continue;
            }
            result = getRange(range, targetNum);
            if (result[0] > 0 && result[1] > 0) {
                break;
            }
        }
        return result;
    }

    /**
     * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
     * elements = [1, -3, 4, 5]
     * target = 9
     * result = range(2, 4) # because elements[2] + elements[3] == target
     */
    public static int[] task10_getRange_Threads(List<List<Integer>> ranges, int targetNum, int countThreads) {
        int[] result = new int[2];
        int i = 0;

        Iterator<List<Integer>> rangesIts = ranges.iterator();

        List<Integer> range;
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < Math.ceil((double) ranges.size() / countThreads); j++) {

            for (int k = 0; k < countThreads; k++) {
                if (rangesIts.hasNext()) {
                    range = rangesIts.next();

                    if (range.size() < 2) {
                        continue;
                    }

                    i++;

                    Thread t = new Thread(new RangeThread(range, targetNum), "thread" + i);
                    t.start();
                    threads.add(t);
                }
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.out.printf("%s has been interrupted", thread.getName());
                }
            }
            threads.clear();
            System.out.println(Thread.currentThread().getName() + " started");

            if (RangeThread.getResult()[0] > 0 && RangeThread.getResult()[1] > 0) {
                result = RangeThread.getResult();
                break;
            }
        }

        return result;
    }

    /**
     * Даны две строки.
     * Написать функцию, которая вернёт True,
     * если из первой строки можно получить вторую,
     * совершив не более 1 изменения (== удаление / замена символа).
     */
    public static boolean task9_is_chg_first_str_to_second(String str1, String str2) {
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);

        if (str1.equals(str2)) {
            throw new RuntimeException("Error! Strings equals");
        }

        int lenStr1 = str1.length();
        int lenStr2 = str2.length();

        if (Math.abs(lenStr1 - lenStr2) > 1) {
            throw new RuntimeException("Error! Strings differents more than one char");
        }

        // посимвольное удаление в первой строке
        if (lenStr1 > lenStr2) {
            for (int i = 0; i < str1.length(); i++) {
                StringBuilder builderStr1 = new StringBuilder(str1);
                builderStr1.deleteCharAt(i);
                if (builderStr1.toString().equals(str2)) {
                    return true;
                }
            }
        }

        // посимвольное добавление в первой строке из второй
        if (lenStr1 < lenStr2) {
            for (int i = 0; i < str2.length(); i++) {
                for (int j = 0; j <= str1.length(); j++) {
                    StringBuilder builderStr1 = new StringBuilder(str1);
                    builderStr1.insert(j, str2.charAt(i));
                    if (builderStr1.toString().equals(str2)) {
                        return true;
                    }
                }
            }
        }

        // посимвольная замена в первой строке из второй
        if (lenStr1 == lenStr2) {
            for (int i = 0; i < str2.length(); i++) {
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        continue;
                    }
                    StringBuilder builderStr1 = new StringBuilder(str1);
                    builderStr1.replace(j, j + 1, String.valueOf(str2.charAt(i)));
                    if (builderStr1.toString().equals(str2)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 2, 0};
        int[] arr2 = new int[]{5, 0, 1, 2, 7, 3, 2};
//        int[] arr1 = fillArrRand(new int[100]);
//        int[] arr2 = fillArrRand(new int[100]);

//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));

//        System.out.println(new Timestamp(System.currentTimeMillis()));
//        task1(arr1, arr2);
//        System.out.println(new Timestamp(System.currentTimeMillis()));

//        System.out.println(new Timestamp(System.currentTimeMillis()));
//        task1_v2(arr1, arr2);
//        System.out.println(new Timestamp(System.currentTimeMillis()));

//        System.out.println(new Timestamp(System.currentTimeMillis()));
//        System.out.println(task1_v3(arr1, arr2));
//        System.out.println(new Timestamp(System.currentTimeMillis()));

        //String str = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        String str = "AABBC";
        System.out.println(task2_RLE(str));
        System.out.println(task2_RLE_v2(str));

//        System.out.println(getCountRepeatChars(str));

//        System.out.println(task3(new int[]{1, 4, 2, 3, 5, 6, 8, 9, 10, 12, 15}));
        //System.out.println(task3(new int[]{1}));

//        System.out.println(task4(new int[]{0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}));

//        System.out.println(task5_getMaxGuests(new int[][]{
//                {1, 2},
//                {1, 3},
//                {2, 4},
//                {2, 3},
//        }));

        //System.out.println(task6_getStringGroups(new String[]{"eat", "eat", "tea", "tan", "ate", "nat", "bat"}));

        //System.out.println(task7_getMergedRanges(new int[][]{{1, 3}, {0, 2}, {4, 6}, {8, 9}, {100, 200}}));

//        List<List<Integer>> ranges = Collections.synchronizedList(new ArrayList<>());
//        ranges.add(Arrays.asList(4));
//        //ranges.add(Arrays.asList(4, 5));
//        ranges.add(Arrays.asList(1, 2, 4));
//        ranges.add(Arrays.asList(1, 2, 2, 5, 7));
//        ranges.add(Arrays.asList(1, 4, 6, 8, 7));
//        ranges.add(Arrays.asList(1, 1, 3, 2, 4));
//        ranges.add(Arrays.asList(3, 4, 5, 6));
//        ranges.add(Arrays.asList(1, 5, 5, 4));
//        System.out.println(Arrays.toString(task10_getRange_Threads(ranges, 9, 2)));

//        System.out.println(task9_is_chg_first_str_to_second("azbci", "azbcu"));


    }
}
