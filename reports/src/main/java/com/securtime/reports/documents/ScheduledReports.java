package com.securtime.reports.documents;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "SchedulerReports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledReports implements Serializable {

    @Id
    private int id;
    private String affiliateName;
    private String emails;
    private String query;
    private String scheduledDate;
    private String scheduledTime;

}
