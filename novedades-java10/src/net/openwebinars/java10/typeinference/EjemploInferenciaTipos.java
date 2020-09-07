package net.openwebinars.java10.typeinference;

import java.util.List;
import java.util.stream.Collectors;

public class EjemploInferenciaTipos {

    public static void main(String[] args) {

        // Infiere que es una lista de Integer
        var list = List.of(1, 2, 3, 4, 5);
        //List<Integer> = ...
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        // Infiere que es un String
        var string = "Cadena de caracteres";
        System.out.println(string);

        // Infiere que es un array de enteros
        var array = new int[]{1, 2};
        // Esta notación no sería válida
        // var otroarray = {1, 2};

        // Infiere que es una referencia a un objeto de la clase MyType
        var mitipo = new MyType("Cadena", 1);
        System.out.println(mitipo);

        // La expresión es correcta, pero Java no sabría que hacer. El IDE no lanza un error
        // var x;


        // Null no es inferible
        // var nulo  = null;

        // var no es una palabra reservada (permite compatibilidad hacia atrás)
        int var = 1;





    }

}
