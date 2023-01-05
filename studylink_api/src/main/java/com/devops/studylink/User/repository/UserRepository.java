package com.devops.studylink.User.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.devops.studylink.User.repository.entities.UserEntity;
import com.devops.studylink.User.service.User;

@Service
public class UserRepository {
    
    private final UserDao userDao;
    public UserRepository(UserDao s) {
        this.userDao = s;
    }
    public List<User> getAll() {
        return userDao.findAll().stream().map(s -> new User(s)).collect(Collectors.toList());
    }

    public Optional<User> getUserById(UUID id) {
        return userDao.findById(id).map( p -> new User(p) );
    }

    public User createUser(User u) {
        UserEntity tmp = new UserEntity(u); 
        return new User(userDao.save( tmp ));
    }

    public void deleteUser(UUID id) {
        userDao.delete( userDao.findById(id).get() );
    }

    public User updateUser(UUID id, User user) {
        UserEntity save = new UserEntity(user); 
        save.setId(id);
        return new User (userDao.save( save ) );
    }

}
