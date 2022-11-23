package com.devops.studylink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.Secteur.dto.SecteurDto;
import com.devops.studylink.Secteur.service.SecteurService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/secteurs")
public class SecteurController {
    
    private final SecteurService secteurService;
    public SecteurController(SecteurService s) {
        this.secteurService = s;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<SecteurDto> getAll() {
        return this.secteurService.getAll().stream().map(s -> new SecteurDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SecteurDto> getById() {
        
        return null;
    }
    
    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SecteurDto> create() {
        
        return null;
    }

    @DeleteMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SecteurDto> delete() {
        
        return null;
    }

    @PatchMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SecteurDto> update() {
        
        return null;
    }

}
