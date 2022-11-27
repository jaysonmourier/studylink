package com.devops.studylink.stats.service;

import java.util.List;
import org.springframework.stereotype.Service;
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
    

}
