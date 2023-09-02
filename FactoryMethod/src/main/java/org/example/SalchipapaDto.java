package org.example;

import java.math.BigDecimal;


public class SalchipapaDto {

    private String tipo;
    private String salsas;
    private String tamanio;
    private BigDecimal precio;

    public SalchipapaDto(String tipo, String salsas, String tamanio, BigDecimal precio) {
        this.tipo = tipo;
        this.salsas = salsas;
        this.tamanio = tamanio;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "SalchipapaDto{" +
                "tipo='" + tipo + '\'' +
                ", salsas='" + salsas + '\'' +
                ", tamanio='" + tamanio + '\'' +
                ", precio=" + precio +
                '}';
    }

}
