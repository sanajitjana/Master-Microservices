package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFoundException("Invalid user id: " + id);
        return user.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = findById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(userToUpdate);
    }

    @Override
    public User partialUpdateUser(int id, User user) {
        User userToUpdate = findById(id);
        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if (user.getDateOfBirth() != null) {
            userToUpdate.setDateOfBirth(user.getDateOfBirth());
        }
        return userRepository.save(userToUpdate);
    }

    @Override
    public User deleteUser(int id) {
        User userToBeDelete = findById(id);
        userRepository.delete(userToBeDelete);
        return userToBeDelete;
    }

    @Override
    public List<Post> getAllPost(int userId) {
        User user = findById(userId);
        return user.getPosts();
    }
}
