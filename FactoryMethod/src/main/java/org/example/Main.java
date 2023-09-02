package org.example;

public class Main {
    public static void main(String[] args) {

        Restaurante restauranteMexicano = new ChefMexicano();
        Salchipapa ordenMexicana = restauranteMexicano.ordenarSalchipapa();

        Restaurante restauranteColombiano = new ChefColombiano();
        Salchipapa  ordenColombiana = restauranteColombiano.ordenarSalchipapa();

        Restaurante restauranteArgentina = new ChefColombiano();
        Salchipapa  ordenargentina = restauranteArgentina.ordenarSalchipapa();

    }
}