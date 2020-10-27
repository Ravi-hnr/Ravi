package com.securtime.reports.EmailService;


import com.securtime.reports.utilities.ApplicationConstants;
import com.securtime.reports.utilities.SupportStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@EnableAsync
public class EmailBuilder {
    private static final Logger LOGGER = LogManager.getLogger(EmailBuilder.class);

    @Autowired
    private EmailSender email;

    @Async
    public void sendEmailWithAttachmentForClients(String to, File attachment, String fileName) {

        try {
            String subject = "CustomReport" + ApplicationConstants.DATE;
            email.sendMailWithAttachment(to, subject, SupportStorage.reportsBody(), attachment, fileName);
        } catch (Exception e) {
            LOGGER.error(ApplicationConstants.CLASSNAME + this.getClass().getSimpleName() + ", "
                    + ApplicationConstants.METHODNAME + " sendEmailWithAttachmentForClients" + ", " + ApplicationConstants.ERROR
                    + e.getMessage());
        }
    }
}