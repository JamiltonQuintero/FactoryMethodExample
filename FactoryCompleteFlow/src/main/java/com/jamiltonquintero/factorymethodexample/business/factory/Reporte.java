package com.jamiltonquintero.factorymethodexample.business.factory;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class Reporte {

    public ReportData generarReporte(ReportTypeEnum reportTypeEnum, List<?> data) throws DocumentException, IOException {
        ReportGenerator reportGenerator = crearReporte();
        var reporte = reportGenerator.generateReport(reportTypeEnum, data);
        saveFileOnCloud(reporte);
        return reporte;
    }

    private void saveFileOnCloud(ReportData data) {
        //Servicio Cloud respladar PDF
        System.out.println("Respaldando en cloud archivo tipo " + crearReporte().getType()+  Arrays.toString(data.getData()));
    }

    public abstract ReportGenerator crearReporte();

}
