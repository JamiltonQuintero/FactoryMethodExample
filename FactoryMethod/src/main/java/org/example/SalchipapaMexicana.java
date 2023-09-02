package org.example;

import java.math.BigDecimal;

public class SalchipapaMexicana implements Salchipapa {
    @Override
    public SalchipapaDto preparar() {
        // aqui se prepara una salchipapa mexicano
        return new SalchipapaDto("SalchipapaMexicana","sin salsas","pequena", new BigDecimal(4445));
    }
}
