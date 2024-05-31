package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @PatchMapping("/users/{id}")
    public User partialUpdateUser(@PathVariable int id, @RequestBody User user){
        return userService.partialUpdateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}
