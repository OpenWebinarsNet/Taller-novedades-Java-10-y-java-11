package net.openwebinars.java11.typeinference;

import java.util.Map;

public class EjemploInferenciaLambda {

    public static void main(String[] args) {

        Map<String, Integer> poblaciones = Map.of("Sevilla", 700_000,
                "Málaga", 500_000, "Córdoba", 325_000, "Granada", 232_000,
                "Almería", 198_000, "Huelva", 143_000, "Cádiz", 116_000,
                "Jaén", 112_000);

        // Se infieren los tipos a partir de la estructura de datos poblaciones
        poblaciones.forEach((var x, var y) -> System.out.printf("%s: %d habitantes\n", x, y));
        // Con la sintaxis de lambda, también podemos obviar var
        System.out.println();
        poblaciones.forEach((x,y) -> System.out.printf("%s: %d habitantes\n", x, y));


        // Si usamos var, lo usamos en todos los argumentos
        // En caso contrario, error de compilación
        // poblaciones.forEach((x, var y) -> System.out.printf("%s: %d habitantes\n", x, y));
        // poblaciones.forEach((String x, var y) -> System.out.printf("%s: %d habitantes\n", x, y));



    }

}
