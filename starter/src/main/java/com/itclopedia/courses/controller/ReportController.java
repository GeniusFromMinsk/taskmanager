package com.itclopedia.courses.controller;

import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReport(@RequestBody Report report) {
        reportService.addReport(report);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateReport(@RequestBody Report report) {
        reportService.updateReport(report);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReportById(@PathVariable int id) {
        return new ResponseEntity<>(reportService.getReportById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}