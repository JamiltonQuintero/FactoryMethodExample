package org.example;

public class Main {
    public static void main(String[] args) {

        Restaurante restauranteMexicano = new ChefMexicano();
        Salchipapa salchipapaMexicano = restauranteMexicano.ordenarSalchipapa();

        Restaurante restauranteColombiano = new ChefColombiano();
        Salchipapa  salchipapaColombiano = restauranteColombiano.ordenarSalchipapa();

    }
}