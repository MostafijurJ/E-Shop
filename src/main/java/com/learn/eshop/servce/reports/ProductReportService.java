package com.learn.eshop.servce.reports;

import com.learn.eshop.domain.Product;
import com.learn.eshop.repository.jpa.ProductRepository;
import com.learn.eshop.repository.schema.ProductEntity;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductReportService {

  private final String path = "/home/mr/Downloads";

  private final ProductRepository productRepository;

  public ProductReportService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public String exportProductReport(String reportFormat) throws FileNotFoundException, JRException {

    List<ProductEntity> productEntities = productRepository.findAll();
    List<Product> products = new ArrayList<>();
    for (var product : productEntities) {
      products.add(entityToDomain(product));
    }

    // TODO load file and compile it
    File file = ResourceUtils.getFile("classpath:product.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
    Map<String, Object> parameter = new HashMap<>();
    parameter.put("Created by", "ESHOP");

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

    // TODO generate format wise report
    if (reportFormat.equalsIgnoreCase("html")) {
      JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/product.html\"");
    }
    if (reportFormat.equalsIgnoreCase("pdf")) {
      JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/product.pdf");
    }
    if (reportFormat.equalsIgnoreCase("xml")) {
      JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/product.xml");
    }

    return "report Successfully generated !";
  }

  private Product entityToDomain(ProductEntity entity) {
    var domain = new Product();
    BeanUtils.copyProperties(entity, domain);
    return domain;
  }
}
