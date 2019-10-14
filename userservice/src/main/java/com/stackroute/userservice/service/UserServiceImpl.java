package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistsException("User Already Exists");
        }
        User savedUser = userRepository.save(user);
        if(savedUser ==null){
            throw new UserAlreadyExistsException("User Already Exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User updateUser(User user) {
        User updatedUser = userRepository.getOne(user.getId());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setAge(user.getAge());
        return userRepository.save(updatedUser);
    }
}
