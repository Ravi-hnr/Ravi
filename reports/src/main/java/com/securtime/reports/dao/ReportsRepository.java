package com.securtime.reports.dao;

import com.securtime.reports.documents.Reports;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportsRepository extends MongoRepository<Reports, Integer> {
}
