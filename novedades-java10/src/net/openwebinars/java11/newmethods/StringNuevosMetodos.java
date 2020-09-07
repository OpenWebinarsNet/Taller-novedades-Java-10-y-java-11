package net.openwebinars.java11.newmethods;

public class StringNuevosMetodos {

    public static void main(String[] args) {

        var cadena1 = "   En un lugar de La Mancha   ";
        var cadena2 = "     ";

        // strip() elimina espacios en blanco iniciales y finales
        // si la cadena está vacía o solo tiene espacios, devuelve una cadena vacía
        System.out.println(cadena1.strip());
        System.out.println(cadena2.isEmpty());
        System.out.println(cadena2.strip().isEmpty());


        // stripLeading() o stripTrailing() realizan la misma operación
        // pero sólo al inicio o al final de la cadena
        System.out.println(cadena1.stripLeading());
        System.out.println(cadena1.stripTrailing());

        // isBlank devuelve true si toda la cadena está vacía
        // solo contiene espacios en blanco
        System.out.println("isEmpty() -> " + cadena2.isEmpty());
        System.out.println("isBlank() -> " + cadena2.isBlank());

        // lines() extrae un Stream<String> de una cadena,
        // separada por las terminaciones de línea (\n)
        var texto = "Una línea\nOtra línea\nOtra línea más";
        System.out.println("Nº de líneas: " + texto.lines().count());


        // repeat(n) repite una cadena de caracteres n veces,
        // devolviendo como resultado la concatenación de las mismas
        var concat = "asdfg ".repeat(5);
        System.out.println(concat);


    }

}
