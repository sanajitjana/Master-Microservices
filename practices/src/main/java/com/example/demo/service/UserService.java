package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User findById(int id);

    public User createUser(User user);

    public User updateUser(int id, User user);

    public User partialUpdateUser(int id, User user);

    public User deleteUser(int id);
}
