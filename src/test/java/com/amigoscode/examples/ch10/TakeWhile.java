package com.amigoscode.examples.ch10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TakeWhile {

    @Test
    public void takeWhile() throws Exception {

        // using filter
        System.out.println("using filter");
        Stream.of(2,4,6,8,9,10).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
        Stream.of(2,4,6,8,9,10).takeWhile(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));

    }
}
