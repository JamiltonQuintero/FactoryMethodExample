package com.jamiltonquintero.factorymethodexample.business.factory.impl;

import com.jamiltonquintero.factorymethodexample.business.factory.ReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.strategies.ExcelReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.business.strategies.PdfReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ExcelReportGenerator implements ReportGenerator {

    private final Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy;

    @Autowired
    public ExcelReportGenerator(Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy) {
        this.reportContentStrategy = reportContentStrategy;
    }

    @Override
    public ReportFormatEnum getType() {
        return ReportFormatEnum.EXCEL;
    }

    @Override
    public ReportData generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook();

        ExcelReportContentStrategy<?> strategy = this.reportContentStrategy.get(reportTypeEnum);
        addContentUsingStrategy(strategy, workbook, data);

        workbook.write(outputStream);
        workbook.close();
        return new ReportData(outputStream.toByteArray(),
                MediaType.parseMediaType("application/vnd.ms-excel"),
                "report.xls");

    }

    @SuppressWarnings("unchecked")
    private <T> void addContentUsingStrategy(ExcelReportContentStrategy<T> strategy, XSSFWorkbook workbook, List<?> data) {
        if (!data.isEmpty() && strategy.getClase().isInstance(data.get(0))) {
            XSSFSheet sheet = workbook.createSheet("Report");
            strategy.addExcelContent(sheet, (List<T>) data);
        } else {
            throw new IllegalArgumentException("Mismatched data type!");
        }
    }
}
