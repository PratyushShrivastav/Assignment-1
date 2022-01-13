package com.project.rest.controller;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public UserInfoEntity getUserDetails(@RequestParam int userId){

        System.out.println(userId);
        return userRepository.findById(userId);
    }

    @GetMapping("/testapiUser")
    public String helloUser(){
        return "hey89";
    }


    @PostMapping("/user") public String insertUserDetails(@RequestBody UserInfoEntity user){
         userRepository.save(user);
        //System.out.println(userId);
        return "Successfully added your information to database";
    }





}
