package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.StaticUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/static")
public class StaticUserController {

    @Autowired
    private StaticUserService staticUserService;

    @GetMapping("/users")
    public List<User> users() {
        return staticUserService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id) {
        return staticUserService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = staticUserService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        HttpHeaders header = new HttpHeaders();
        header.setLocation(location);
        return new ResponseEntity<>(savedUser, header, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return staticUserService.updateUser(id, user);
    }

    @PatchMapping("/users/{id}")
    public User partialUpdateUser(@PathVariable int id, @RequestBody User user) {
        return staticUserService.partialUpdateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id) {
        return staticUserService.deleteUser(id);
    }

}
