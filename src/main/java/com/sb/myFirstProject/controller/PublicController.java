package com.sb.myFirstProject.controller;

import com.sb.myFirstProject.entity.User;
import com.sb.myFirstProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            userService.saveNewUser(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
