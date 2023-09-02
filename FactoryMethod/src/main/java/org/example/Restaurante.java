package org.example;

public abstract class Restaurante {

    public void ordenarSalchipapa() {
        Salchipapa salchipapa = crearSalchipapa();
        var salchipapaDto = salchipapa.preparar();

        // Logica de negocio concreta. Ejemplo : delivery, cliente que pide etc.
        guardarRegistroCreacion(salchipapaDto);
        encontrarDomiciliario(salchipapaDto);
        enviar(salchipapaDto);

    }

    private void guardarRegistroCreacion(SalchipapaDto salchipapaDto) {
        System.out.println("Guardando en bd" + salchipapaDto);
    }

    private void encontrarDomiciliario(SalchipapaDto salchipapaDto) {
        System.out.println("Buscando domiciliario" + salchipapaDto);
    }

    private void enviar(SalchipapaDto salchipapaDto) {
        System.out.println("Enviando domiciliario" + salchipapaDto);
    }

    public abstract Salchipapa crearSalchipapa();

}
