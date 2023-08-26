package com.jamiltonquintero.factorymethodexample.business.strategies;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;

import java.util.List;

public interface PdfReportContentStrategy<T> {
    boolean appliesTo(ReportTypeEnum reportTypeEnum);
    Class<T> getType();
    void portada(Document document) throws DocumentException;

    PdfPTable tabla(List<T> objs);
    boolean conclusion(Document document) throws DocumentException;
}

