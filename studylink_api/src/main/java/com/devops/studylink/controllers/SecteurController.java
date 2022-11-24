package com.devops.studylink.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.Secteur.dto.SecteurCreationDto;
import com.devops.studylink.Secteur.dto.SecteurDto;
import com.devops.studylink.Secteur.service.Secteur;
import com.devops.studylink.Secteur.service.SecteurService;
import com.devops.studylink.exceptions.ResourceNotFoundException;
import com.devops.studylink.exceptions.StudyLinkApiException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/secteurs")
public class SecteurController {
    
    /**| INIT |**/

    private final SecteurService secteurService;
    public SecteurController(SecteurService s) {
        this.secteurService = s;
    }

    /**| ENDPOINTS |**/

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<SecteurDto> getAll() {
        return this.secteurService.getAll().stream().map(s -> new SecteurDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity getById(@PathVariable("uuid") String id) {
        try {
            return ResponseEntity.ok(
                new SecteurDto( secteurService.getById(UUID.fromString(id)) )
            );
        }
        catch(ResourceNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(StudyLinkApiException e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
    }
    
    @PostMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity create(@RequestBody SecteurCreationDto secteurDto) {
        try {
            return ResponseEntity.ok(
                new SecteurDto(secteurService.createSecteur( new Secteur(secteurDto) ))
            );
        }
        // catch(StudyLinkApiException e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
        catch(Exception e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
    }

    @DeleteMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity delete(@PathVariable("uuid") String id) {
        try {
            secteurService.delete(UUID.fromString(id));
            return ResponseEntity.noContent().build();
        }
        catch(ResourceNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(StudyLinkApiException e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
    }

}
