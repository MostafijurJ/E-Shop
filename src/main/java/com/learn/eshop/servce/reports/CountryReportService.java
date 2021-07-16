package com.learn.eshop.servce.reports;

import com.learn.eshop.domain.Country;
import com.learn.eshop.repository.jpa.CountryRepository;
import com.learn.eshop.repository.schema.CountryEntity;
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
public class CountryReportService {
    private final CountryRepository countryRepository;

    public CountryReportService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public String exportCountryReport(String reportFormat) throws FileNotFoundException, JRException {

        List<CountryEntity> countryEntities = countryRepository.findAllByOrderByName();
        List<Country> countries = new ArrayList<>();
        for (var country : countryEntities) {
            countries.add(entityToDomain(country));
        }

        //TODO load file and compile it

        File file = ResourceUtils.getFile("classpath:country.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(countries);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("Created by", "ESHOP");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

        //TODO generate format wise report
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "/home/mr/Downloads\"+\"/country.html\"");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/mr/Downloads" + "/country.pdf");
        }

        return "report Successfully generated !";
    }

    private Country entityToDomain(CountryEntity entity) {
        var domain = new Country();
        BeanUtils.copyProperties(entity, domain);
        return domain;
    }

}
