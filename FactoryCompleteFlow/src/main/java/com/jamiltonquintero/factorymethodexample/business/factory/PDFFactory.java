package com.jamiltonquintero.factorymethodexample.business.factory;

import com.jamiltonquintero.factorymethodexample.business.factory.impl.PDFReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.strategies.PdfReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PDFFactory extends Reporte {
    private Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy;

    public PDFFactory(Set<PdfReportContentStrategy> types) {
        this.reportContentStrategy = new HashMap<>();
        types.forEach(type -> this.reportContentStrategy.put(type.getType(), type));
    }
    @Override
    public ReportGenerator crearReporte() {
        return new PDFReportGenerator(reportContentStrategy);
    }
}
