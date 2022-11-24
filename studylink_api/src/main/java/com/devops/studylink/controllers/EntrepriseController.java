package com.devops.studylink.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devops.studylink.entreprise.dto.EntrepriseDto;
import com.devops.studylink.entreprise.service.Entreprise;
import com.devops.studylink.entreprise.service.EntrepriseService;
import com.devops.studylink.exceptions.ResourceNotFoundException;
import com.devops.studylink.exceptions.StudyLinkApiException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {
    
    private final EntrepriseService entrepriseService;
    public EntrepriseController(EntrepriseService e) {
        this.entrepriseService = e;
    }
    
    /**| ENDPOINTS |**/

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public List<EntrepriseDto> getAll() {
        return entrepriseService.getAll().stream().map(EntrepriseDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity getId(@PathVariable("uuid") String id) {
        try {
            return ResponseEntity.ok(
                new EntrepriseDto( entrepriseService.getById(UUID.fromString(id)) )
            );
        }
        catch(ResourceNotFoundException | IllegalArgumentException e) { return ResponseEntity.notFound().build(); }
        catch(StudyLinkApiException e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity create(@RequestBody EntrepriseDto entrepriseDto) {
        try {
            return ResponseEntity.ok(
                new EntrepriseDto( entrepriseService.create(new Entreprise(entrepriseDto)) )
            );
        }
        catch(StudyLinkApiException e) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); }
    }

}
