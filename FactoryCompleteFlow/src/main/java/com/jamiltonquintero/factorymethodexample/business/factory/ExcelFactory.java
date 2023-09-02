package com.jamiltonquintero.factorymethodexample.business.factory;

import com.jamiltonquintero.factorymethodexample.business.factory.impl.ExcelReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.strategies.ExcelReportContentStrategy;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExcelFactory extends Reporte {
    private Map<ReportTypeEnum, ExcelReportContentStrategy> reportContentStrategy;

    public ExcelFactory(Set<ExcelReportContentStrategy> types) {
        this.reportContentStrategy = new HashMap<>();
        types.forEach(type -> this.reportContentStrategy.put(type.getType(), type));
    }
    @Override
    public ReportGenerator crearReporte() {
        return new ExcelReportGenerator(reportContentStrategy);
    }
}
