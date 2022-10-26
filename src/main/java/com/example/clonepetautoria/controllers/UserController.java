package com.example.clonepetautoria.controllers;


import com.example.clonepetautoria.models.UserModel;
import com.example.clonepetautoria.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<UserModel> update(@RequestBody UserModel user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }
}
