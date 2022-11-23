package com.devops.studylink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import com.devops.studylink.Salaire.dto.SalaireDto;
import com.devops.studylink.Salaire.service.SalaireService;

@RestController
@RequestMapping("/salaire")
public class SalaireController {
    
    private final SalaireService SalaireService;
    public SalaireController(SalaireService s) {
        this.SalaireService = s;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<SalaireDto> getAll() {
        return this.SalaireService.getAll().stream().map(s -> new SalaireDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SalaireDto> getById() {
        
        return null;
    }
    
    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SalaireDto> create() {
        
        return null;
    }

    @DeleteMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SalaireDto> delete() {
        
        return null;
    }

    @PatchMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<SalaireDto> update() {
        
        return null;
    }

}
