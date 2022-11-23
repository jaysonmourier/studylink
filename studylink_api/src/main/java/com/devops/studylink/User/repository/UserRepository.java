package com.devops.studylink.User.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
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

}
