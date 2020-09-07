package net.openwebinars.java11.tls1_3;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/*
    Este código es el código disponible en la documentación de Oracle JDK 10
    https://docs.oracle.com/javase/10/security/sample-code-illustrating-secure-socket-connection-client-and-server.htm#JSSEC-GUID-B9103D0C-3E6A-4301-B558-461E4CB23DC9
    Se han hecho algunas modificaciones para que funcione plenamente con TLS 1.3
 */
public class EjemploTLS1_3 {

    public static void main(String[] args) throws IOException {

        // Construimos el socket hacia la URL correspondiente
        SSLSocketFactory factory =
                (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket =
                (SSLSocket) factory.createSocket("www.google.es", 443);

        // Habilitamos TLS 1.3
        socket.setEnabledProtocols(new String[]{"TLSv1.3"});
        // Se establece un algoritmo de cifrado de entre los que ofrece esta versión.
        // Puedes encontrar más información en el RFC correspondiente (RFC 8446 https://tools.ietf.org/html/rfc8446)
        socket.setEnabledCipherSuites(new String[]{"TLS_AES_256_GCM_SHA384"});

        /*
         * Envío de la petición HTTP
         *
         * Antes de que cualquier dato se envíe, el socket SSL realiza primero el "handshake"
         * para establecer los atributos de seguridad.
         *
         * El handskahe se puede iniciar descargando datos o de forma explícita.
         *
         * En este ejemplo se inicia manualmente, ya que PrintWriter captura las
         * excepciones IOException (incluidas SSLException). Por tanto, esto implica
         * que perderíamos los mensajes de error, causando mucha confusión.
         * La única forma de comprobar si hay un error es a través de PrintWriter.checkError().
         *
         */
        // Iniciamos el handshake
        socket.startHandshake();

        // Realizamos la petición
        PrintWriter pw = new PrintWriter(
                            new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()
                                )
                            )
                         );

        pw.println("GET / HTTP/1.0");
        pw.println("");
        pw.flush();

        // Comprobamos que no hay errores
        if (pw.checkError()) {
            System.out.println("Error SSL con PrintWriter");
        }

        // Leemos la respuesta
        BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(
                                            socket.getInputStream()
                                    )
                                );

        String line;
        while ((line = reader.readLine()) != null)
            System.out.println(line);

        // Cerramos los flujos y la conexión
        reader.close();
        pw.close();
        socket.close();


    }

}
