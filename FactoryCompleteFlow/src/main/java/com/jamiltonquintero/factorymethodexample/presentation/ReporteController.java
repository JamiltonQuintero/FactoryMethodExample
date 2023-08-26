package com.jamiltonquintero.factorymethodexample.presentation;

import com.itextpdf.text.DocumentException;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportTypeEnum;
import com.jamiltonquintero.factorymethodexample.domain.enums.ReportFormatEnum;
import com.jamiltonquintero.factorymethodexample.business.servcie.ReporteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReporteController {
    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generar(@RequestParam ReportFormatEnum reporteFormat, @RequestParam ReportTypeEnum reportType) throws DocumentException, IOException {

        var reportData = reporteService.execute(reporteFormat, reportType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(reportData.getMediaType());
        headers.setContentDispositionFormData("filename", reportData.getFilename());

        return new ResponseEntity<>(reportData.getData(), headers, HttpStatus.OK);
    }

}
