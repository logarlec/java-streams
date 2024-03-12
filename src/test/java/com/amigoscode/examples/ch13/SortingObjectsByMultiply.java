package com.amigoscode.examples.ch13;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingObjectsByMultiply {

    @Test
    public void sortingSteamOfObjetsReversed2() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getEmail).reversed();

        List<Person> sorted = people.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> topTenBlueCars = cars.stream()
                .filter(car->car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(10)
                .collect(Collectors.toList());
        topTenBlueCars.forEach(System.out::println);
    }
}
