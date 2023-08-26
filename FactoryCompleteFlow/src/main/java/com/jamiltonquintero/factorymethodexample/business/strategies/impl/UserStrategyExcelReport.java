package com.jamiltonquintero.factorymethodexample.business.strategies.impl;

import com.jamiltonquintero.factorymethodexample.domain.entity.User;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.business.strategies.ExcelReportContentStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStrategyExcelReport implements ExcelReportContentStrategy<User> {

    @Override
    public boolean appliesTo(ReportTypeEnum reportTypeEnum) {
        return reportTypeEnum == ReportTypeEnum.USER;
    }

    @Override
    public Class<User> getType() {
        return User.class;
    }

    @Override
    public void addExcelContent(XSSFSheet sheet, List<User> users) {
        int rowCount = 0;

        // Título
        Row titleRow = sheet.createRow(rowCount++);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("REPORTE USUARIOS");
        // Puedes agregar estilos adicionales si lo deseas

        rowCount++;  // Espacio en blanco

        // Encabezados de la tabla
        Row headerRow = sheet.createRow(rowCount++);
        var fields = users.get(0).getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(fields[i].getName());
            // Puedes agregar estilos adicionales si lo deseas
        }

        // Contenido de la tabla
        for (User user : users) {
            Row userRow = sheet.createRow(rowCount++);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                try {
                    Object value = fields[i].get(user);
                    userRow.createCell(i).setCellValue(value.toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Total de edades
        long totalAge = users.stream().map(User::getName).count();
        Row totalRow = sheet.createRow(rowCount++);
        Cell totalTextCell = totalRow.createCell(0);
        totalTextCell.setCellValue("Total de edades:");
        Cell totalValueCell = totalRow.createCell(1);
        totalValueCell.setCellValue(totalAge);
        // Puedes agregar estilos adicionales si lo deseas
    }

}

