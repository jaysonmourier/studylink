package com.devops.studylink.User.service;

import com.devops.studylink.User.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository s) {
        this.userRepository = s;
    }
    
    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    public User getUserById(UUID id) {
        Optional<User> result = userRepository.getUserById(id);
        return result.get();
    }

    public User createUser(User u) {
        return userRepository.createUser(u);
    }

    public void deteUser(UUID id) {
        userRepository.deleteUser(id);
    }

    public User updateUser(UUID id, User update){
        User user = this.getUserById(id);
        user.update(update);
        return userRepository.updateUser(id, user);
    }
    
}
