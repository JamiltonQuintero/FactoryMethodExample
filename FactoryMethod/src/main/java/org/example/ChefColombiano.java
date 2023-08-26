package org.example;

public class ChefColombiano extends Restaurante{
    @Override
    public Salchipapa crearSalchipapa() {
        return new SalchipapaColombiana();
    }
}
