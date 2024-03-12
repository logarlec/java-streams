package com.amigoscode.examples.ch14;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        StringBuilder sb = new StringBuilder();
        for(String name:names){
            sb.append(name.substring(0,1).toUpperCase().concat(name.substring(1))).append(", ");
        }
        System.out.println(sb.substring(0,sb.length()-2));
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        String join = names.stream()
                .map(name->name.substring(0,1).toUpperCase().concat(name.substring(1)))
                .collect(Collectors.joining(", "));
        System.out.println(join);
     }
}
