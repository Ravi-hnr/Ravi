package com.securtime.reports.controller;


import com.securtime.reports.documents.Reports;
import com.securtime.reports.documents.ScheduledReports;
import com.securtime.reports.service.ReportsService;
import com.securtime.reports.utilities.ApiSuccess;
import com.securtime.reports.utilities.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
@Validated
public class ReportsController {


    @Autowired
    private ReportsService reportsService;

    @PostMapping("/saveReports")
    public ResponseEntity<Object> saveReports(@RequestBody Reports data) throws IOException, SQLException, ClassNotFoundException {
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, reportsService.saveAndSendReports(data)));
    }

    @GetMapping("/getAllReports")
    public ResponseEntity<Object> getAllReports() throws IOException, SQLException, ClassNotFoundException {
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, reportsService.getReports()));
    }

    @PostMapping("/scheduleReports")
    public ResponseEntity<Object> saveScheduledReports(@RequestBody ScheduledReports data) throws IOException, SQLException, ClassNotFoundException {
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, reportsService.saveScheduledReports(data)));
    }

    @GetMapping("/getScheduledReports")
    public ResponseEntity<Object> getScheduledReports() throws IOException, SQLException, ClassNotFoundException {
        return CommonUtils.buildResponseEntity(new ApiSuccess(HttpStatus.OK, reportsService.getScheduledReports()));
    }

}
