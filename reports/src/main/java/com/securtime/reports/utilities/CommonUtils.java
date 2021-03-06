package com.securtime.reports.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

public class CommonUtils {

    private CommonUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);

    // formatting of the success response
    public static ResponseEntity<Object> buildResponseEntity(ApiSuccess apiSuccess) {
        LOGGER.info("Success : " + apiSuccess.toString());
        return new ResponseEntity<>(apiSuccess, apiSuccess.getStatus());
    }
}
