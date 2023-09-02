package org.example;

public abstract class Restaurante {

    public Salchipapa ordenarSalchipapa() {
        Salchipapa salchipapa = crearSalchipapa();
        // Logica de negocio concreta. Ejemplo : delivery, cliente que pide etc.
        var salchipapaDto = salchipapa.preparar();

        guardarRegistroCreacion(salchipapaDto);
        encontrarDomiciliario(salchipapaDto);
        enviar(salchipapaDto);

        return salchipapa;
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
