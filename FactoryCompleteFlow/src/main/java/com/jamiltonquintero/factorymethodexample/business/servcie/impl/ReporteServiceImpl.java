package com.jamiltonquintero.factorymethodexample.business.servcie.impl;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.business.factory.ExcelFactory;
import com.jamiltonquintero.factorymethodexample.business.factory.PDFFactory;
import com.jamiltonquintero.factorymethodexample.business.factory.Reporte;
import com.jamiltonquintero.factorymethodexample.business.servcie.DataProvider;
import com.jamiltonquintero.factorymethodexample.business.servcie.ReporteService;
import com.jamiltonquintero.factorymethodexample.business.factory.ReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.strategies.ExcelReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.business.strategies.PdfReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ReporteServiceImpl implements ReporteService {

    private Map<ReportTypeEnum, DataProvider<?>> dataProviders;
    private Map<ReportFormatEnum, ReportGenerator> reportGenerators;
    private Set<PdfReportContentStrategy> typesPdf;
    private Set<ExcelReportContentStrategy> typesExcel;

    @Autowired
    public ReporteServiceImpl(Set<DataProvider<?>> types, Set<ReportGenerator> formats, Set<PdfReportContentStrategy> typesPdf, Set<ExcelReportContentStrategy> typesExcel) {
        this.typesPdf = typesPdf;
        this.typesExcel = typesExcel;
        this.dataProviders = new HashMap<>();
        this.reportGenerators = new HashMap<>();
        types.forEach(type -> this.dataProviders.put(type.getType(), type));
        formats.forEach(format -> this.reportGenerators.put(format.getType(), format));
    }


    @Override
    public ReportData execute(ReportFormatEnum reportFormatEnum, ReportTypeEnum reportTypeEnum) throws DocumentException, IOException {

        List<?> data = dataProviders.get(reportTypeEnum).getData();

        Reporte reporte;
        switch (reportFormatEnum){
            case PDF:
                reporte = new PDFFactory(typesPdf);
                break;
            case EXCEL:
                reporte = new ExcelFactory(typesExcel);
                break;
            default:
                throw new IllegalArgumentException("");
        }

        return reporte.generarReporte(reportTypeEnum, data);

    }
}
