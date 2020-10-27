package com.securtime.reports.service;


import com.securtime.reports.EmailService.EmailBuilder;
import com.securtime.reports.dao.ReportsRepository;
import com.securtime.reports.dao.ScheduledReortsRepository;
import com.securtime.reports.documents.Reports;
import com.securtime.reports.documents.ScheduledReports;
import com.securtime.reports.utilities.JDBCExcelWritter;
import com.securtime.reports.utilities.SupportStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@Slf4j
@Service
public class ReportsService {

    @Autowired
    private EmailBuilder emailBuilder;

    @Autowired
    private ReportsRepository reportsRepository;
    @Autowired
    private ScheduledReortsRepository scheduledReortsRepository;


    public Reports saveAndSendReports(Reports data) throws IOException, SQLException, ClassNotFoundException {
        log.info("InputRequest :: {} ", data);
        JDBCExcelWritter.writeData(data.getQuery());
        Arrays.asList(data.getEmails()).stream().forEach(emailAddress -> {
            try {
                emailBuilder.sendEmailWithAttachmentForClients(data.getEmails(), SupportStorage.tempFile().toFile(), SupportStorage.tempFile().getFileName().toString());
                log.info("Emails Sent to :: {} ", emailAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return reportsRepository.save(data);
    }

    public List<Reports> getReports() {
        return reportsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public ScheduledReports saveScheduledReports(ScheduledReports data) {
        return scheduledReortsRepository.save(data);
    }

    public List<ScheduledReports> getScheduledReports() {
        return scheduledReortsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
