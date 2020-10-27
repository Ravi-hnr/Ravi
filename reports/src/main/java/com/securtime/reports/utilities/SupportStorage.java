package com.securtime.reports.utilities;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


public abstract class SupportStorage {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Path tempFile() throws IOException {
        return Files.createTempFile(LocalDate.now().toString(), ".xlsx");
    }

    public static String reportsBody() throws Exception {
        StringWriter body = new StringWriter();
        IOUtils.copy(new FileInputStream(new File("src/main/resources/templates/ReportsBody.html")), body);
        return body.toString();
    }
}
