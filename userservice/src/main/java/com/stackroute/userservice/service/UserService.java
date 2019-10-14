package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserService {

    public User saveUser(User user) throws UserAlreadyExistsException;
    public List<User> getAllUsers();
    public boolean deleteUser(int id);
    public User updateUser(User user);
}

