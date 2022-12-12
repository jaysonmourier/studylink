package com.devops.studylink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.stats.dto.RecordDto;
import com.devops.studylink.stats.service.Record;
import com.devops.studylink.stats.service.StatsService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {
    
    private final StatsService statsService;
    public StatsController( StatsService s ) {
        this.statsService = s;
    }

    @GetMapping("/SalaireMoyen")
    public ResponseEntity<Double> salaireMoyen() {
        return ResponseEntity.ok( statsService.calculSalaireMoyen() );
    }

    @GetMapping("/GetGraphSalaireSecteur") 
    public Map<String, Integer> getGraphSalaireSecteur() {
        return statsService.getGraphSalaireSecteur();
    }

    @PostMapping("/SaveRecord")
    public ResponseEntity<RecordDto> saveRecord( @RequestBody RecordDto record ) {
        statsService.saveRecord( new Record( record ) );
        return ResponseEntity.ok( record );
    }

}
