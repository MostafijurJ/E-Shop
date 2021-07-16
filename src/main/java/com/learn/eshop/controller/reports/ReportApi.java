package com.learn.eshop.controller.reports;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Api(value = "country", tags = "country")
@RequestMapping(path = "/reports")
public interface ReportApi {

  @Operation(summary = "Get all Country reports")
  @GetMapping("/country/{format}")
  ResponseEntity<String> exportCountryReport(@PathVariable String format)
      throws JRException, FileNotFoundException;

  @Operation(summary = "Get all products reports")
  @GetMapping("/product/{format}")
  ResponseEntity<String> exportProductReport(@PathVariable String format)
      throws JRException, FileNotFoundException;
}
