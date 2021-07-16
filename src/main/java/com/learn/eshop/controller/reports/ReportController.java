package com.learn.eshop.controller.reports;

import com.learn.eshop.servce.reports.CountryReportService;
import com.learn.eshop.servce.reports.ProductReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class ReportController implements ReportApi {

  private final CountryReportService countryReportService;
  private final ProductReportService productReportService;

  public ReportController(
      CountryReportService countryReportService, ProductReportService productReportService) {
    this.countryReportService = countryReportService;
    this.productReportService = productReportService;
  }

  @Override
  public ResponseEntity<String> exportCountryReport(String format)
      throws JRException, FileNotFoundException {
    return ResponseEntity.ok(countryReportService.exportCountryReport(format));
  }

  @Override
  public ResponseEntity<String> exportProductReport(String format)
      throws JRException, FileNotFoundException {
    return ResponseEntity.ok(productReportService.exportProductReport(format));
  }
}
