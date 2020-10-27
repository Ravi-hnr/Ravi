package com.securtime.reports.utilities;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class JDBCExcelWritter {

    public static void writeData(String query) throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://securtime.cmh5emqvmt1u.ap-south-1.rds.amazonaws.com:3306/securtime", "support",
                "SuPaSsWoRd");
        if (connection != null) {
            log.info("IS JDBC CLOSED :: {} ", connection.isClosed());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            List<String> columns = new ArrayList<String>() {{
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    add(resultSetMetaData.getColumnLabel(i));
                }
            }};
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet();
                Row rowHeader = sheet.createRow(0);

                for (int i = 0; i < columns.size(); i++) {
                    rowHeader.createCell(i).setCellValue(columns.get(i));
                }
                log.info("Headers Created :: {} ", columns);
                int rowIndex = 0;
                while (resultSet.next()) {
                    Row row = sheet.createRow(++rowIndex);
                    for (int i = 0; i < columns.size(); i++) {
                        row.createCell(i).setCellValue(Objects.toString(resultSet.getObject(columns.get(i)), ""));
                    }
                }
                try (FileOutputStream outputStream = new FileOutputStream(SupportStorage.tempFile().toFile())) {
                    workbook.write(outputStream);
                    connection.close();
                    log.info("JDBC Connetion Closed :: {}", connection.isClosed());

                }
            }
        }
    }


}
