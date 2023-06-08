package com.amiroffir.promotitjava.services.LogServices;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class LogToConsole extends LogService {
    protected static void writeToConsole(String level, String message) {
        String formattedDateTime = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(formattedDateTime + " [" + level + "] " + message);
    }
}