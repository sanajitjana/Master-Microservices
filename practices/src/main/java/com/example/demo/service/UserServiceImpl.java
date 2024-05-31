package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static List<User> userList = new ArrayList<>();
    public static int idCount = 0;

    static {
        userList.add(new User(++idCount, "Brajesh Lovanshi", LocalDate.now().minusYears(23)));
        userList.add(new User(++idCount, "Sanajit Jana", LocalDate.now().minusYears(24)));
        userList.add(new User(++idCount, "Brinda Prajapati", LocalDate.now().minusYears(30)));
        userList.add(new User(++idCount, "Aditya Prakash Mishra", LocalDate.now().minusYears(25)));
        userList.add(new User(++idCount, "Keshav Mishra", LocalDate.now().minusYears(26)));
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User findById(int id) {
        for (User user : userList) {
            if (user.getId() == id) return user;
        }
        throw new UserNotFoundException("Invalid user id: "+id);
    }

    @Override
    public User createUser(User user) {
        user.setId(++idCount);
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        User userToUpdate = findById(id);
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setDateOfBirth(user.getDateOfBirth());
            return userToUpdate;
        }
        return null;
    }

    @Override
    public User partialUpdateUser(int id, User user) {
        User userToUpdate = findById(id);
        if (userToUpdate != null) {
            if (user.getName() != null) {
                userToUpdate.setName(user.getName());
            }
            if (user.getDateOfBirth() != null) {
                userToUpdate.setDateOfBirth(user.getDateOfBirth());
            }
            return userToUpdate;
        }
        return null;
    }

    @Override
    public User deleteUser(int id) {
        User userToBeDelete=findById(id);

        if(userToBeDelete!=null){
            Iterator<User> iterator=userList.iterator();
            while (iterator.hasNext()){
                User user=iterator.next();
                if(user.getId()==id){
                    iterator.remove();
                    return user;
                }
            }
        }
        return null;
    }
}
