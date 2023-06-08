package com.amiroffir.promotitjava.services.LogServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class LogService {

    @Autowired
    private LogToDB LogToDB;
    @Value("${log.destination}")
    private String logDestination;

    protected static int logCounter = 1;
    protected static String logFileName = "log_" + logCounter + ".txt";


    public void logInfo(String message) {
        log("INFO", message);
    }

    public void logError(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        if (logDestination != null) {
            switch (logDestination) {
                case "console":
                    logToConsole(level, message);
                    break;
                case "file":
                    logToFile(level, message);
                    break;
                case "db":
                    logToDatabase(level, message);
                    break;
                default:
                    System.out.println("Invalid log destination configuration");
            }
        } else {
            System.out.println("Log destination not set");
        }
    }

    private void logToConsole(String level, String message) {
        LogToConsole.writeToConsole(level, message);
    }

    private void logToFile(String level, String message) {
        File logFile = new File(logFileName);
        if (!logFile.exists()) {
            LogToFile.createNewLogFile();
        } else {
            if (LogToFile.isFileSizeExceeded(logFile)) {
                LogToFile.createNewLogFile();
            }
        }
        LogToFile.writeToFile(level, message);
    }

    private void logToDatabase(String level, String message) {
        LogToDB.writeToDB(level, message);
    }


}