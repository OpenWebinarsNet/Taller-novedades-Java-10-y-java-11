package net.openwebinars.java10.typeinference;

import java.util.*;

public class Recomendaciones {

    public static void main(String[] args) {

        UnaClase obj = new UnaClase();

        // LEER EL CÓDIGO ES MÁS IMPORTANTE QUE ESCRIBIR EL CÓDIGO
        // Esta expresión es sintácticamente válida, pero no recomendada.
        // ¿Cuál es el tipo de la variable?
        var desconocido = obj.unMetodo();

        // EL CÓDIGO DEBE ESTAR CLARO A PARTIR DEL RAZONAMIENTO LOCAL
        // Ejemplo de un código que resulta inteligible a primera vista, y otro que
        // nos exige visitar otra parte del código.
        var text = "Un texto";
        // ¿De qué tipo es la lista? ¿Es mutable/inmutable? ¿es realmente una lista o un array?
        var variable = list();


        // LOS TIPOS EXPLÍCITOS SE PUEDEN SACRIFICAR SI NO AYUDAN A LA LEGIBILIDAD
        // ¿Cuál de estas declaraciones es más legible?
        Map<String, String> intento1 = new HashMap<String, String>();
        Map<String, String> intento2 = new HashMap<>();
        var intento3 = new HashMap<String, String>();


        // ES PELIGROSA SI SE UTILIZA CON EL OPERADOR DIAMOND
        // Sintáctiamente válido, pero el tipo generado es ArrayList<Object>.
        var tipodesconocido = new ArrayList<>();



    }





    public static class UnaClase {

        public int unMetodo() {
            return 1;
        }


    }

    public static List<String> list() {
        return Collections.emptyList();
    }

}
