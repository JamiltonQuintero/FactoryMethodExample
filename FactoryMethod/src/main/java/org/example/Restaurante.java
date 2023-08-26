package org.example;

public abstract class Restaurante {

    public Salchipapa ordenarSalchipapa() {
        Salchipapa salchipapa = crearSalchipapa();
        salchipapa.preparar();
        return salchipapa;
    }

    public abstract Salchipapa crearSalchipapa();

}
