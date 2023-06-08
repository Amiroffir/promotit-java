package com.amiroffir.promotitjava.services.LogServices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class LogToFile extends LogService {
    protected static boolean isFileSizeExceeded(File file) {
        long fileSize = file.length();
        if (fileSize > 1000000) { // 1MB
            return true;
        }
        return false;
    }

    protected static void createNewLogFile() {
        logFileName = "log_" + ++logCounter + ".txt";
        File newLogFile = new File(logFileName);
        try {
            newLogFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }

    protected static void writeToFile(String level, String message) {
        String formattedDateTime = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            writer.println(formattedDateTime + " [" + level + "] " + message);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}