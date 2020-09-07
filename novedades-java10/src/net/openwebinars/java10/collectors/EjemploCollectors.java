package net.openwebinars.java10.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploCollectors {

    public static void main(String[] args) {
        
        Stream<String> nombres = Stream.of("Pedro", "Juan", "María", "Ana");

        var resultUnmodifiable = nombres
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toUnmodifiableList());

        System.out.println("Nombres en mayúsculas (lista no modificable)");
        resultUnmodifiable.forEach(System.out::println);

        try {
            resultUnmodifiable.add("ALICIA");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Has tratado de añadir un elemento a una colección inmutable");
        }

        // Lo volvemos a declarar porque un stream no se puede
        // recorrer más de una vez.
        Stream<String> nombres2 = Stream.of("Pedro", "Juan", "María", "Ana");

        var resultModifiable = nombres2
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList());

        resultModifiable.add("Alicia");

        System.out.println("\n\nNombres en mayúsculas (lista modificable)");
        resultModifiable.forEach(System.out::println);
    }
    
}
