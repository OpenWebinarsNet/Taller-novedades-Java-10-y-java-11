package net.openwebinars.java11.newmethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesNuevosMetodos {

    public static void main(String[] args) {

        var contenido = "En un lugar de La Mancha, de cuyo nombre no quiero acordarme...";

        try {

            Path path = Files.createTempFile("ejemplo", ".txt");
            // Nos permite escribir en un fichero una cadena de caracteres
            Files.writeString(path, contenido);
            // Nos permite leer el contenido de un fichero en una cadena
            var contenidoLeido = Files.readString(path);
            System.out.println(contenidoLeido);

        } catch (IOException ex) {
            System.out.println("Error de lectura/escritura");
        }



    }

}
