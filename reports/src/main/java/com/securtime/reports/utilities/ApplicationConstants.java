package com.securtime.reports.utilities;/*
 *@created 7/9/20/09/2020-10:46 AM
 *@project SupportTool
 *
 *@author developer
 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApplicationConstants {

    //:::::::::::::::::::::: Strings used in logger ::::::::::::::
    public static final String CLASSNAME = "Class Name : ";
    public static final String METHODNAME = "Method Name : ";
    public static final String REQUESTPARAMETERS = "Request Parameters : ";
    public static final String REQUESTBODY = "Request Body : ";
    public static final String ERROR = "Error : ";
    public static final String DATE = LocalDateTime.now().toString();

    //::::::::::::Application Status::::::::::::::::::::::::::::
    public static final String SUCCESS = "SUCESS";
    public static final String FAILED = "FAILED";





}
