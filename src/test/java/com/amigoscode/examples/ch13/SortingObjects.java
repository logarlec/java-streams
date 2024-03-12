package com.amigoscode.examples.ch13;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingObjects {

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjetsReversed() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjetsReversed2() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator.comparing(Person::getFirstName).reversed();

        List<Person> sorted = people.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

}
