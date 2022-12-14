package com.devops.studylink.stats.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.devops.studylink.Salaire.repository.SalaireRepository;
import com.devops.studylink.Salaire.service.Salaire;
import com.devops.studylink.Secteur.repository.SecteurRepository;
import com.devops.studylink.User.repository.UserRepository;
import com.devops.studylink.entreprise.repository.EntrepriseRepository;

@Service
public class StatsService {
    
    private final UserRepository userRepository;
    private final SecteurRepository secteurRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final SalaireRepository salaireRepository;
    
    public StatsService(UserRepository userRepository, SecteurRepository secteurRepository, EntrepriseRepository entrepriseRepository, SalaireRepository salaireRepository) {
        this.userRepository = userRepository;
        this.secteurRepository = secteurRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.salaireRepository = salaireRepository;
    }

    public Double calculSalaireMoyen() {
        List<Salaire> salaires = salaireRepository.getAll();
        if(salaires.isEmpty()) return 0.0;
        else {
            Double salaireMoy = salaires.stream().map(s -> s.getGrossSalary()).mapToDouble(Double::doubleValue).sum();
            return salaireMoy / salaires.size();
        }
    }

    // Test Dataset for Front graph creation
    public Map<String, Integer> getGraphSalaireSecteur() {
        Map<String, Integer> result = new HashMap<>();
        result.put( "Agroalimentaire", 41788 );
        result.put( "Banque & Assurance", 68938 );
        result.put( "Bois - Papier - Carton - Imprimerie", 60510 );
        result.put( "BTP - Matériaux de construction", 49792 );
        result.put( "Chimie - Parachimie", 59179 );
        result.put( "Commerce - Négoce - Distribution", 55849 );
        result.put( "Edition - Communication - Multimédia ", 64956 );
        result.put( "Électronique - Électricité ", 66747 );
        result.put( "Études & Conseils", 62067 );
        result.put( "Industrie", 47680 );
        result.put( "Pharmaceutique", 43439 );
        result.put( "Informatique - Télécoms", 62665 );
        result.put( "Machines & Équipements", 49522 );
        result.put( "Automobile", 67622 );
        result.put( "Métallurgie", 55089 );
        result.put( "Plastique - Caoutchouc", 57170 );
        result.put( "Services aux Entreprises", 38887 );
        result.put( "Textile - Habillement - Chaussure", 60894 );
        result.put( "Transports - Logistique", 36920 );
        return result;
    }    

}
