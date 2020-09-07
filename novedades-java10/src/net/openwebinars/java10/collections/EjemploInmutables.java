package net.openwebinars.java10.collections;

import java.util.*;

public class EjemploInmutables {

    public static void main(String[] args) {

        // copyOf nos devuelve una copia inmutable de una colección mutable
        var listaMutable = new ArrayList<String>();
        listaMutable.add("uno");
        listaMutable.add("dos");
        listaMutable.add("tres");

        var copiaInmutable = List.copyOf(listaMutable);

        try {
            copiaInmutable.add("cuatro");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Has tratado de añadir un elemento a una colección inmutable");
        }

        copiaInmutable.forEach(System.out::println);

        // copyOf funciona con List, Set y Map
        var setMutable = new HashSet<String>();
        setMutable.add("elem");
        var copiaSetInmutable = Set.copyOf(setMutable);

        var mapMutable = new HashMap<String, String>();
        mapMutable.put("key", "value");
        var copiaMapInmutable = Map.copyOf(mapMutable);


        // copyOf es diferente de Collections.unmodifiableList, Set o Map
        var listaOriginal = new ArrayList<String>();
        listaOriginal.add("Juan");
        listaOriginal.add("Pedro");
        listaOriginal.add("María");

        var copiaConCopyOf = List.copyOf(listaOriginal);
        // unmodifiableList crea en realidad una vista no modificable
        // https://docs.oracle.com/javase/10/docs/api/java/util/Collection.html#unmodview
        var copiaConCollections = Collections.unmodifiableList(listaOriginal);

        listaOriginal.add("Ana");

        System.out.println("\n\nLista original");
        System.out.println("==============");
        listaOriginal.forEach(System.out::println);


        System.out.println("\nLista copiada con copyOf");
        System.out.println("========================");
        copiaConCopyOf.forEach(System.out::println);

        System.out.println("\nLista 'copiada' con unmodifiableList");
        System.out.println("======================================");
        copiaConCollections.forEach(System.out::println);

    }

}
