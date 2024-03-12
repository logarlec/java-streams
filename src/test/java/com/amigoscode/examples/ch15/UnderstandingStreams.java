package com.amigoscode.examples.ch15;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

    @Test
    void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());
        emails.forEach(System.out::println);
    }

    @Test
    void collectInside() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ()-> new ArrayList<String>(),
                        (list,element)-> list.add(element),
                        (list1,list2)->list1.addAll(list2)
                );
        emails.forEach(System.out::println);
    }

    @Test
    void collectInside2() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
        emails.forEach(System.out::println);
    }

    @Test
    public void lazy() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }

    public static class HowStreamsWork {
        @Test
        public void understandingCollect() throws Exception {
            List<String> emails = MockData.getPeople()
                    .stream()
                    .map(Person::getEmail)
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);
        }

        @Test
        public void intermediateAndTerminalOperations() throws Exception {
            System.out.println(
                    MockData.getCars()
                            .stream()
                            .filter(car -> {
                                System.out.println("filter car " + car);
                                return car.getPrice() < 10000;
                            })
                            .map(car -> {
                                System.out.println("mapping car " + car);
                                return car.getPrice();
                            })
                            .map(price -> {
                                System.out.println("mapping price " + price);
                                return price + (price * .14);
                            })
                            .collect(Collectors.toList())
            );
        }
    }
}
