package net.openwebinars.java11.jmc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ErrorDeMemoria {

    public static void main(String[] args) throws InterruptedException {

        // Así nos da tiempo a conectar desde la consola JMC
        Thread.sleep(20000);


        List<BigInteger> lista = new ArrayList<>();
        lista.add(BigInteger.ONE);

        while(true) {
            lista.add(lista.get(lista.size()-1).add(BigInteger.ONE));
        }


    }

}
