package com.learn.eshop.controller.reports;

import com.learn.eshop.servce.reports.CountryReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CountryReportController implements CountryReportApi {

    private final CountryReportService countryReportService;

    public CountryReportController(CountryReportService countryReportService) {
        this.countryReportService = countryReportService;
    }

    @Override
    public ResponseEntity<String> exportCountryReport(String format) throws JRException, FileNotFoundException {
        return ResponseEntity.ok(countryReportService.exportCountryReport(format));
    }
}
