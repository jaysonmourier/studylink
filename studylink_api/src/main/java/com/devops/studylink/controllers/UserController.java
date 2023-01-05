package com.devops.studylink.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.devops.studylink.User.dto.UserCreationDto;
import com.devops.studylink.User.dto.UserDto;
import com.devops.studylink.User.service.User;
import com.devops.studylink.User.service.UserService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    public UserController(UserService s) {
        this.userService = s;
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    public List<UserDto> getAll() {
        return this.userService.getAll().stream().map(s -> new UserDto(s)).collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<UserDto> getUserById( @PathVariable("uuid") String id ) {
        
        return ResponseEntity.ok( new UserDto( userService.getUserById( UUID.fromString(id) ) ) );
    }
    
    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity createUser(@RequestBody UserCreationDto userDto) {
        try {
            return new ResponseEntity<UserDto> (
                new UserDto( userService.createUser( new User(userDto) ) ), HttpStatus.CREATED
            );
        }
        catch( Exception e ) { return ResponseEntity.badRequest().build(); }
    }

    @DeleteMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity deleteUser(@PathVariable("uuid") String id) {
        userService.deteUser( UUID.fromString(id) );
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity updateUser( @PathVariable("uuid") String id, @RequestBody UserCreationDto userDto ) {
        try {
            return ResponseEntity.ok(
                new UserDto( userService.updateUser(UUID.fromString(id), new User(userDto)) )
            );
        }
        catch( Exception e ) { return ResponseEntity.badRequest().build(); }
    }

}
