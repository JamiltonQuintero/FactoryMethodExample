package com.jamiltonquintero.factorymethodexample.business.service.factory.impl;

import com.jamiltonquintero.factorymethodexample.business.service.factory.ReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.service.factory.strategies.ExcelReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReporteFormatEnum;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelReportGenerator implements ReportGenerator {

    private final List<ExcelReportContentStrategy<?>> contentStrategies;

    @Autowired
    public ExcelReportGenerator(List<ExcelReportContentStrategy<?>> contentStrategies) {
        this.contentStrategies = contentStrategies;
    }

    @Override
    public ReporteFormatEnum getType() {
        return ReporteFormatEnum.EXCEL;
    }

    @Override
    public byte[] generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XSSFWorkbook workbook = new XSSFWorkbook();

        ExcelReportContentStrategy<?> strategy = contentStrategies.stream()
                .filter(s -> s.appliesTo(reportTypeEnum))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy found for " + reportTypeEnum));

        addContentUsingStrategy(strategy, workbook, data);

        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }

    @SuppressWarnings("unchecked")
    private <T> void addContentUsingStrategy(ExcelReportContentStrategy<T> strategy, XSSFWorkbook workbook, List<?> data) {
        if (!data.isEmpty() && strategy.getType().isInstance(data.get(0))) {
            XSSFSheet sheet = workbook.createSheet("Report");
            strategy.addExcelContent(sheet, (List<T>) data);
        } else {
            throw new IllegalArgumentException("Mismatched data type!");
        }
    }
}
