package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StringParser {
    public static void main(String[] args) {
        String str = getString();

        System.out.println("Version #1:");
        Map<String, SortedSet<String>> stringMap = Arrays.stream(str.split(","))
                .collect(HashMap::new,
                        (map, item) -> {
                            String[] a1 = item.split("\\|");
                            String mapKey = a1[1];
                            String setVal = a1[0];
                            SortedSet<String> mapVal = map.get(mapKey);
                            if (mapVal == null) {
                                mapVal = new TreeSet<>();
                            }
                            mapVal.add(setVal);
                            map.put(mapKey, mapVal);
                        },
                        HashMap::putAll
                );

        System.out.println(stringMap);

        System.out.println("Version #2:");
        Map<Object, SortedSet<String>> stringMap2 = Arrays.stream(str.split(","))
                .collect(Collectors.groupingBy(el -> el.split("\\|")[1],
                        Collectors.mapping(el -> el.split("\\|")[0], Collectors.toCollection(TreeSet::new))));
        System.out.println(stringMap2);
    }

    private static String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Караганда|kz,");
        stringBuilder.append("Астана|kz,");
        stringBuilder.append("Алматы|kz,");
        stringBuilder.append("Тараз|kz,");
        stringBuilder.append("Новосибирск|ru,");
        stringBuilder.append("Самара|ru,");
        stringBuilder.append("Тверь|ru,");
        stringBuilder.append("Атырау|kz,");
        stringBuilder.append("Актау|kz,");
        stringBuilder.append("Ташкент|uz");
        String str = stringBuilder.toString();
        return str;
    }

}
