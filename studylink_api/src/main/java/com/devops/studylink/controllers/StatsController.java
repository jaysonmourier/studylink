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
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/stats")
public class StatsController {
    
    private final StatsService statsService;
    public StatsController( StatsService s ) {
        this.statsService = s;
    }

    /** Salaire moyen **/
    @GetMapping("/data/salaire-moyen")
    public ResponseEntity<Float> salaireMoyen() {
        return ResponseEntity.ok( statsService.getSalaireMoyen() );
    }

    /** Top 3 des domaines avec salaires les plus élevés */
    @GetMapping("/data/top-3-domains") 
    public Set<String> top3DomainsBySalary() {
        return statsService.top3DomainsBySalary();
    }

    /** Salaire moyen selon les secteurs d'activité **/
    @GetMapping("/barchart/secteur-salaire") 
    public Map<String, Float> barchartSecteurSalaire() {
        return statsService.barchartSecteurSalaire();
    }

    /** Liste des salaires par secteur d'activité **/
    @GetMapping("/histogram/secteur-salaires")
    public Map<String, List<Float>> histogramSecteurSalaire() {
        return statsService.histogramSecteurSalaire();
    }

    @PostMapping("/SaveRecord")
    public ResponseEntity<RecordDto> saveRecord( @RequestBody RecordDto record ) {
        statsService.saveRecord( Record.create( record ) );
        return ResponseEntity.ok( record );
    }

}
