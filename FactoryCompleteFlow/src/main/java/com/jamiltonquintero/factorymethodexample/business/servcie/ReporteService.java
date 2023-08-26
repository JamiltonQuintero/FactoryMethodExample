package com.jamiltonquintero.factorymethodexample.business.servcie;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;

import java.io.IOException;

public interface ReporteService {

    ReportData execute(ReportFormatEnum reportFormatEnum, ReportTypeEnum reportTypeEnum) throws DocumentException, IOException;

}
