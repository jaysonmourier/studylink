package com.devops.studylink.User.service;

import com.devops.studylink.Secteur.repository.SecteurRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(SecteurRepository s) {
        this.userRepository = s;
    }
    
    public List<User> getAll() {
        return this.userRepository.getAll();
    }
    
}
