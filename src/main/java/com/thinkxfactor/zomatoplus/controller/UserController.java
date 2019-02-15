package com.thinkxfactor.zomatoplus.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.model.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
   
    @Autowired
	UserRepository userRepository;
   
    @GetMapping("/get")
    public User getUser(@RequestParam int id) {
        return userRepository.findById(id).get();
    }
   
    @GetMapping("/getAll")
    public Collection<User> getUser() {
        return userRepository.findAll();
    }
   
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
}