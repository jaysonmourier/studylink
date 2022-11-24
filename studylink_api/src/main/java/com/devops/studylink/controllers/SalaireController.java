package com.devops.studylink.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.devops.studylink.Salaire.dto.SalaireCreationDto;
import com.devops.studylink.Salaire.dto.SalaireDto;
import com.devops.studylink.Salaire.service.Salaire;
import com.devops.studylink.Salaire.service.SalaireService;
import com.devops.studylink.exceptions.PostException;
import com.devops.studylink.exceptions.PostNotFoundException;

@RestController
@RequestMapping("/salaire")
public class SalaireController {
    
    private final SalaireService salaireService;
    public SalaireController(SalaireService s) {
        this.salaireService = s;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<SalaireDto> getAll() {
        return this.salaireService.getAll().stream().map(s -> new SalaireDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity getById(@PathVariable("uuid") String id) {
        try {
            return ResponseEntity.ok( new SalaireDto( salaireService.getPostById( UUID.fromString(id) ) ) );
        }
        catch(PostNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(PostException e) { return ResponseEntity.badRequest().body(e.getMessage()); }
    }
    
    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity create(@RequestBody SalaireCreationDto salaireDto) {
        try {
            return new ResponseEntity<SalaireDto> (
                new SalaireDto( salaireService.createSalaire(new Salaire(salaireDto))), HttpStatus.CREATED
            );
        }
        catch( PostException e ) { return ResponseEntity.badRequest().body(e.getMessage()); }
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
