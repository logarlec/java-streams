package com.amigoscode.examples.ch11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformationsWithFlatMap {

    private static final List< List<String> > arraylistOfNames = List.of(
            List.of("Mariam","Alex","Ismail"),
            List.of("John","Alesha","Andre"),
            List.of("Sisy","Ali")
    );

    @BeforeEach
    void setUp(){
        System.out.println(arraylistOfNames);
    }

    @Test
   public void withoutFlatMap() throws Exception {
        List<String> names = new ArrayList<>();
        for(List<String>  strings : arraylistOfNames){
            names.addAll(strings);
        }
        System.out.println(names);
   }

   @Test
   public void withFlatMap()  throws Exception {

       List<String> names =  arraylistOfNames.stream()
               .flatMap(List::stream)
               .collect(Collectors.toList());
       System.out.println(names);
   }

   @Test
   public void flatMapWithOptionals() throws Exception {

        List<Optional<String>> optionals = List.of(
                Optional.of("Amigos"),
                Optional.of("Code")
        );

        List<String> names = optionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
       System.out.println(names);
   }


}
