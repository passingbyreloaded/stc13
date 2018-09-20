package ru.innopolis.stc13.stream;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        Collection<String> collection = Arrays.asList("v1", "v3", "v2", "v3", "v2", "v3", "v1", "v4");
//        List<String> distinct = collection.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinct);
//
//        String joined = collection.stream().collect(Collectors.joining(":", "prefix", "suffix"));
//        System.out.println(joined);
//
//        Map<String, String> map = collection.stream().distinct().collect(Collectors.toMap(p -> p.substring(1), p -> p.substring(0, 1)));
//        System.out.println(map);

        Summ summ = (a, b) -> a + b;
        Max max = list -> list.stream()
                .max(Integer::compareTo)
                .get();
        Average average = list -> list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        Factorial factorial = a -> IntStream.rangeClosed(2, a)
                .reduce(1, (x, y) -> x * y);

        System.out.println(factorial.factorial(3));
    }
}
