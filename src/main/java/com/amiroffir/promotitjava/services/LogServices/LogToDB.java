package com.amiroffir.promotitjava.services.LogServices;

import com.amiroffir.promotitjava.models.LogItem;
import com.amiroffir.promotitjava.repos.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogToDB {
    @Autowired
    private LogRepo logRepo;

    protected void writeToDB(String level, String message) {
        LogItem logItem = new LogItem(level, message);
        logRepo.save(logItem);
    }
}