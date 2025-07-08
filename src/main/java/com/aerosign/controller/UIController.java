package com.aerosign.controller;

import com.aerosign.entity.FlightLog;
import com.aerosign.repository.FlightLogRepository;
import com.aerosign.service.FlightDocumentService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class UIController {

    private final FlightLogRepository flightLogRepository;
    private final FlightDocumentService flightDocumentService;

    public UIController(FlightLogRepository flightLogRepository, FlightDocumentService flightDocumentService) {
        this.flightLogRepository = flightLogRepository;
        this.flightDocumentService = flightDocumentService;
    }

    @GetMapping("/logs")
    public String showLogs(Model model){
        List<FlightLog> logs = flightLogRepository.findAll();
        model.addAttribute("logs", logs);
        return "logs";
    }

    @GetMapping("/generate/{id}")
    public ResponseEntity<Resource> generatePdf(@PathVariable Long id) throws Exception{
        String filePath = flightDocumentService.processFlightLog(id);
        Path path = Paths.get(filePath);
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + path.getFileName().toString())
                .body(resource);
    }
}
