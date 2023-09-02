package com.jamiltonquintero.factorymethodexample.business.factory;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;

import java.io.IOException;
import java.util.List;

public interface ReportGenerator {
    ReportFormatEnum getType();
    ReportData generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws DocumentException, IOException;
}
