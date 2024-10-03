package com.itclopedia.courses.controller;

import com.itclopedia.courses.dto.ReportDTO;
import com.itclopedia.courses.dto.TaskDTO;
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

    @PostMapping()
    public ResponseEntity<String> addReport(@RequestBody ReportDTO reportDTO) {
        reportService.addReport(reportDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<String> updateReport(@RequestBody ReportDTO reportDTO) {
        reportService.updateReport(reportDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable int id) {
        ReportDTO reportDTO = reportService.getReportById(id);
        return new ResponseEntity<>(reportDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
