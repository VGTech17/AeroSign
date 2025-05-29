package com.aerosign.controller;

import com.aerosign.entity.FlightLog;
import com.aerosign.service.FlightLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight-logs")
public class FlightLogController {

    private final FlightLogService flightLogService;

    public FlightLogController (FlightLogService flightLogService){
        this.flightLogService = flightLogService;
    }

    @GetMapping
    public List<FlightLog> getAllLogs(){
        return flightLogService.getAllLogs();
    }

    @GetMapping("/status/{status}")
    public List<FlightLog> getLogsByStatus(@PathVariable String status){
        return flightLogService.getLogsByStatus(status);
    }
}
