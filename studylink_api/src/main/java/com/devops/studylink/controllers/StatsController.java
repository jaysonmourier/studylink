package com.devops.studylink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.stats.service.StatsService;
import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    
    private final StatsService statsService;
    public StatsController( StatsService s ) {
        this.statsService = s;
    }

    @GetMapping("/salaireMoyen")
    public ResponseEntity<Double> salaireMoyen() {
        return ResponseEntity.ok( statsService.calculSalaireMoyen() );
    }

    @GetMapping("/salaireEvol") 
    public List<Integer> salaireEvol() {
        // TODO : Salaire Evol (Create new query in SalaireDao)
        return null;
    }


}
