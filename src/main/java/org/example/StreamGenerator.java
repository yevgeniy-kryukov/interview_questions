package org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGenerator {
    public static void main(String[] args) {
        Supplier<Integer> randomizer = () -> new Random().nextInt(1000);
        Stream.generate(randomizer)
                .limit(10)
                .sorted(Comparator.naturalOrder())
                .forEach(e -> System.out.println(e));
    }

}
