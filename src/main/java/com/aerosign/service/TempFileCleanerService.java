package com.aerosign.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TempFileCleanerService {

    public static final String TEMP_FOLDER_PATH = "temp/";

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void cleanTempFiles(){
        File folder = new File(TEMP_FOLDER_PATH);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        boolean deleted = file.delete();
                        System.out.println("[TempCleaner] Удалён файл: " + file.getName() + " — " + deleted);
                    }
                }
            }
        }
    }
}
