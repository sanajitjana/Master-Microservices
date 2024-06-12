package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> users() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        HttpHeaders header = new HttpHeaders();
        header.setLocation(location);
        return new ResponseEntity<>(savedUser, header, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @PatchMapping("/{id}")
    public User partialUpdateUser(@PathVariable int id, @RequestBody User user) {
        return userService.partialUpdateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getAllPost(@PathVariable int userId) {
        return userService.getAllPost(userId);
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post post) {
        Post res= userService.createPost(userId, post);
        return new ResponseEntity<Post>(res, HttpStatus.CREATED);
    }
}
