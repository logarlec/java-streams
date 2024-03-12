package com.amigoscode.examples.ch07;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

    @Test
    public void rangeFor() throws Exception {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void rangeIntStreamExclusive() throws Exception {
        IntStream.range(0,10).forEach(System.out::println);
    }

    @Test
    public void rangeIntStreamInclusive() throws Exception {
        IntStream.rangeClosed(0,10).forEach(System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size()).forEach(index->{
            System.out.println(people.get(index));
        });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0,v -> v+1*2)
                .limit(11)
                .forEach(System.out::println);
    }
}
