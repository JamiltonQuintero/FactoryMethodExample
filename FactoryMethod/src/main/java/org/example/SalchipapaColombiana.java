package org.example;

import java.math.BigDecimal;

public class SalchipapaColombiana implements Salchipapa {
    @Override
    public SalchipapaDto preparar() {
        // aqui se prepara una salchipapa colombiana
        return new SalchipapaDto("SalchipapaColombiana","rosada, roja","mediano", new BigDecimal(22336));
    }
}
