package com.jamiltonquintero.factorymethodexample.business.servcie.impl;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.business.servcie.DataProvider;
import com.jamiltonquintero.factorymethodexample.business.servcie.ReporteService;
import com.jamiltonquintero.factorymethodexample.business.factory.ReportGenerator;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Autowired
    public ReporteServiceImpl(Set<DataProvider<?>> types, Set<ReportGenerator> formats) {
        this.dataProviders = new HashMap<>();
        this.reportGenerators = new HashMap<>();
        types.forEach(type -> this.dataProviders.put(type.getType(), type));
        formats.forEach(format -> this.reportGenerators.put(format.getType(), format));
    }


    @Override
    public ReportData execute(ReportFormatEnum reportFormatEnum, ReportTypeEnum reportTypeEnum) throws DocumentException, IOException {

        MediaType mediaType = null;
        String filename;

        switch(reportFormatEnum) {
            case PDF:
                mediaType = MediaType.APPLICATION_PDF;
                filename = "report.pdf";
                break;

            case EXCEL:
                mediaType = MediaType.parseMediaType("application/vnd.ms-excel");
                filename = "report.xls";
                break;

            default:
                throw new IllegalArgumentException("Tipo de reporte no soportado");
        }
        List<?> data = dataProviders.get(reportTypeEnum).getData();

        ReportGenerator report = reportGenerators.get(reportFormatEnum);
        byte[] generatedReport = report.generateReport(reportTypeEnum, data);

        return new ReportData(generatedReport, mediaType, filename);

    }
}
