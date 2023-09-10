package org.gdas.bigreportsapi.controller;

import org.gdas.bigreportsapi.model.json.EmployeeJSON;
import org.gdas.bigreportsapi.service.ReportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class ReportsController {

    private final ReportsService reportsService;

    public ReportsController(ReportsService reportsService) {
        this.reportsService = reportsService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeJSON>> get(
            @RequestParam("created_at")LocalDate createdAt
            ) {
        return ResponseEntity.noContent().build();
    }

}
