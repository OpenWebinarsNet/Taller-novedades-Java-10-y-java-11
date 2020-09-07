package net.openwebinars.java10.optional;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class EjemploOptional {

    public static void main(String[] args) throws Exception {

        Optional<String> posibleVacio = process();

        var result = posibleVacio
                        .orElseThrow(() -> new Exception("Mensaje de la excepción"));


        System.out.println(result);
    }


    public static Optional<String> process() {
        var randomValue = ThreadLocalRandom.current().nextInt();
        return  randomValue % 2 == 0 ? Optional.empty() : Optional.of(Integer.toString(randomValue));
    }

}
