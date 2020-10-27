package com.securtime.reports.dao;

import com.securtime.reports.documents.ScheduledReports;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduledReortsRepository extends MongoRepository<ScheduledReports, Integer> {
}
