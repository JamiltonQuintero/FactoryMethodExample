package com.jamiltonquintero.factorymethodexample.business.service.factory;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReporteFormatEnum;

import java.io.IOException;
import java.util.List;

public interface ReportGenerator {
    ReporteFormatEnum getType();
    byte[] generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws DocumentException, IOException;
}
