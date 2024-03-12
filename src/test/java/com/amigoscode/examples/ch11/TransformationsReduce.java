package com.amigoscode.examples.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TransformationsReduce {

    @Test
    public void reduce() {

        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers).reduce(0,(a,b)->a+b);
        int sum2 = Arrays.stream(integers).reduce(0,Integer::sum);
        int sub = Arrays.stream(integers).reduce(0,(a,b)->a-b);

        System.out.println(sum);
        System.out.println(sum2);
        System.out.println(sub);

    }

    public static class TransformationsWithFlatMap {

        private static final List<List<String>> arrayListOfNames = List.of(
                List.of("Mariam", "Alex", "Ismail"),
                List.of("John", "Alesha", "Andre"),
                List.of("Susy", "Ali")
        );

        @BeforeEach
        void setUp() {
            System.out.println(arrayListOfNames);
        }

        @Test
        public void withoutFlatMap() throws Exception {
            // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
            List<String> names = new ArrayList<>();
        }

        @Test
        public void withFlatMap() throws Exception {
            // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        }

        @Test
        public void flatMapWithOptionals() {
            List<Optional<String>> optionals = List.of(
                    Optional.of("Amigos"),
                    Optional.of("Code")
            );
        }
    }
}
