package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
     ResponseEntity responseEntity;
     try{
         userService.saveUser(user);
         responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
     }catch (UserAlreadyExistsException e){
         responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
     }
     return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        return new ResponseEntity<Boolean>(userService.deleteUser(id),HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PATCH,value = "user")
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
    }
}
