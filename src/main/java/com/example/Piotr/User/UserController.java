package com.example.Piotr.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Zwraca dane do klienta - wyświetlanie danych
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public ResponseEntity<String> printOK(){
        return ResponseEntity.ok("It works");

    } // ResponseEntity
    @GetMapping("/test")
    public ResponseEntity<User> getUser(String name, String surName, String userName) {
        return ResponseEntity.ok(userService.getUser(name,surName,userName));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(Long id) {
        return ResponseEntity.ok(userService.FindById(id));
    }
}
