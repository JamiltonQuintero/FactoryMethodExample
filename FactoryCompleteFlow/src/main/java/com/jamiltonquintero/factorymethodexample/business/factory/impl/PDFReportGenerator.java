package com.jamiltonquintero.factorymethodexample.business.factory.impl;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jamiltonquintero.factorymethodexample.domain.dto.ReportData;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import com.jamiltonquintero.factorymethodexample.business.factory.ReportGenerator;
import com.jamiltonquintero.factorymethodexample.business.strategies.PdfReportContentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Service
public class PDFReportGenerator implements ReportGenerator {

    private final Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy;

    @Autowired
    public PDFReportGenerator(Map<ReportTypeEnum, PdfReportContentStrategy> reportContentStrategy) {
        this.reportContentStrategy = reportContentStrategy;
      }
    @Override
    public ReportFormatEnum getType() {
        return ReportFormatEnum.PDF;
    }
    @Override
    public ReportData generateReport(ReportTypeEnum reportTypeEnum, List<?> data) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        PdfReportContentStrategy<?> strategy = this.reportContentStrategy.get(reportTypeEnum);
        addContentUsingStrategy(strategy, document, data);

        document.close();
        return new ReportData(outputStream.toByteArray(),
                MediaType.APPLICATION_PDF,
                "report.pdf");
    }

    @SuppressWarnings("unchecked")
    private <T> void addContentUsingStrategy(PdfReportContentStrategy<T> strategy, Document document, List<?> data) throws DocumentException {
        if (!data.isEmpty() && strategy.getClase().isInstance(data.get(0))) {
            //strategy.addContent(document, (List<T>) data);
            strategy.portada(document);
            document.add(strategy.tabla((List<T>) data));
            document.newPage();

            var isComplex = strategy.conclusion(document);

            if (isComplex){
                document.newPage();
                Font titleComplex = FontFactory.getFont(FontFactory.COURIER, 100, BaseColor.ORANGE);

                Paragraph titleParagraph = new Paragraph("ESTA MUY COMPLEJA ESTA LOGICA", titleComplex);
                titleParagraph.setAlignment(Element.ALIGN_CENTER);
                titleParagraph.setSpacingBefore(document.getPageSize().getHeight() / 2 - titleComplex.getSize());
                document.add(titleParagraph);

            }
        } else {
            throw new IllegalArgumentException("Mismatched data type!");
        }
    }
}

