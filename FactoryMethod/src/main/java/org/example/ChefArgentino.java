package org.example;

public class ChefArgentino extends Restaurante {
    @Override
    public Salchipapa crearSalchipapa() {
        return new SalchipapaArgentina();
    }

}
