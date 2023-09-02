package org.example;

public class Main {
    public static void main(String[] args) {

        Restaurante restauranteMexicano = new ChefMexicano();
        restauranteMexicano.ordenarSalchipapa();

        Restaurante restauranteColombiano = new ChefColombiano();
        restauranteColombiano.ordenarSalchipapa();

        Restaurante restauranteArgentina = new ChefColombiano();
        restauranteArgentina.ordenarSalchipapa();

    }
}