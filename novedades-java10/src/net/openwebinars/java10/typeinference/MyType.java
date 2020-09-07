package net.openwebinars.java10.typeinference;

import java.util.Objects;

public class MyType {

    private String cadena;
    private int entero;


    public MyType() {
    }

    public MyType(String cadena, int entero) {
        this.cadena = cadena;
        this.entero = entero;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    public String getCadena() {
        return cadena;
    }

    public int getEntero() {
        return entero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyType myType = (MyType) o;
        return entero == myType.entero &&
                Objects.equals(cadena, myType.cadena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadena, entero);
    }

    @Override
    public String toString() {
        return "MyType{" +
                "cadena='" + cadena + '\'' +
                ", entero=" + entero +
                '}';
    }
}
