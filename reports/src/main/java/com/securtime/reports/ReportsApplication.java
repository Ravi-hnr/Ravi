package com.securtime.reports;

import java.io.DataOutput;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securtime.reports.documents.Reports;
import com.securtime.reports.documents.ScheduledReports;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.securtime.reports")
@EnableScheduling
public class ReportsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReportsApplication.class, args);
  }

}
