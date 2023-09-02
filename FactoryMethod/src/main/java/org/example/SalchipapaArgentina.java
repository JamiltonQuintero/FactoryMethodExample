package org.example;

import java.math.BigDecimal;

public class SalchipapaArgentina implements Salchipapa {
    @Override
    public SalchipapaDto preparar() {
        // aqui se prepara una salchipapa argentino
        return new SalchipapaDto("SalchipapaArgentina","todas","Grande", new BigDecimal(5000));
    }
}
