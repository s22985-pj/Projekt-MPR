package com.example.Piotr.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Zwraca dane do klienta - wyświetlanie danych
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public ResponseEntity<String> printOK(){
        return ResponseEntity.ok("It works");

    } // ResponseEntity
    @GetMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestParam String name,@RequestParam String surName,@RequestParam String userName) {
        return ResponseEntity.ok(userService.createUser(name,surName,userName));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.FindById(id));
    }

    @GetMapping("/getAll")
    public List<User> ListUsers(){
        return userService.ListUsers();
    }
}
