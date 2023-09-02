package com.jamiltonquintero.factorymethodexample.business.strategies;

import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;

public interface ExcelReportContentStrategy<T> {
    Class<T> getClase();
    ReportTypeEnum getType();
    void addExcelContent(XSSFSheet sheet, List<T> data);
}

