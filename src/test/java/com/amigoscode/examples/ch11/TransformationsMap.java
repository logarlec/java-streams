package com.amigoscode.examples.ch11;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMap {

    @Test
    void yourFirstTransformationWithMapFirst() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .map(person-> {
                PersonDTO personDTO = new PersonDTO (person.getId(), person.getFirstName(), person.getAge());
                return personDTO;
                })
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isEqualTo(dtos.size());
        dtos.stream().forEach(System.out::println);
    }

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .map(person->new PersonDTO(person.getId(),person.getFirstName(),person.getAge()))
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isEqualTo(dtos.size());
        dtos.stream().forEach(System.out::println);
    }

    @Test
    void yourFirstTransformationWithMapAndFilter() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream()
                .filter(person->person.getAge()>20)
                .map(person->new PersonDTO(person.getId(),person.getFirstName(),person.getAge()))
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isGreaterThan(dtos.size());
        dtos.stream().forEach(System.out::println);
    }

   @Test
    void yourFirstTransformationWithMapAndFunction() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person,PersonDTO> person2PersonDTOFunction = person ->
                new PersonDTO(person.getId(),
                        person.getFirstName(),
                        person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person->person.getAge()>20)
                .map(person2PersonDTOFunction)
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isGreaterThan(dtos.size());
         dtos.stream().forEach(System.out::println);
    }

    @Test
    void yourFirstTransformationWithMapAndMethodReference() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person,PersonDTO> person2PersonDTOFunction = person ->
                new PersonDTO(person.getId(),
                        person.getFirstName(),
                        person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person->person.getAge()>20)
                .map(PersonDTO::map)
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isGreaterThan(dtos.size());
        dtos.stream().forEach(System.out::println);
    }

    @Test
    void yourFirstTransformationWithMapAndMethodReference2() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person,PersonDTO> person2PersonDTOFunction = person ->
                new PersonDTO(person.getId(),
                        person.getFirstName(),
                        person.getAge());

        Function<Person,PersonDTO> map = PersonDTO::map;

        List<PersonDTO> dtos = people.stream()
                .filter(person->person.getAge()>20)
                .map(map)
                .collect(Collectors.toList());
        System.out.println(dtos);
        assertThat(people.size()).isGreaterThan(dtos.size());
        dtos.stream().forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> people = MockData.getCars();

        double average = people.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(average);
    }

}
