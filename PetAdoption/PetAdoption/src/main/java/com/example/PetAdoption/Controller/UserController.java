package com.example.PetAdoption.Controller;

import com.example.PetAdoption.Model.UserEntity;
import com.example.PetAdoption.Services.Userservice;
import com.example.PetAdoption.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private Userservice userservice;


    @GetMapping(value="/getUser")
    public
    List<UserEntity> getAllUsers() {
        return userservice.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userservice.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userservice.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

}
