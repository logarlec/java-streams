package com.amigoscode.examples.ch08;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {

        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer min = numbers.stream().min((o1,o2)->o1.compareTo(o2)).get();
        System.out.println(min);

        min = numbers.stream().min(Integer::compareTo).get();
        System.out.println(min);

        min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println(min);

    }

    @Test
    public void max() {

        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer max = numbers.stream().max((o1,o2)->o1.compareTo(o2)).get();
        System.out.println(max);

        max = numbers.stream().max(Integer::compareTo).get();
        System.out.println(max);

        max = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);


    }
}
