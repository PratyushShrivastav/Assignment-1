package com.project.rest.controller;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("/user")
    public UserInfoEntity getUserDetails(@RequestParam int userId) {

        return userservice.getuser(userId);
    }


    @PostMapping("/user")
    public String insertUserDetails(@RequestBody UserInfoEntity user) {

        return userservice.postuser(user);
    }

    @PutMapping("/user")
    public String updateuserdetails(@RequestParam int userId, @RequestBody UserInfoEntity user) {

        return userservice.putuser(userId, user);
    }

    @DeleteMapping("/user")
    public String deleteuserdetails(@RequestParam int userId) {

        return userservice.deletedetails(userId);

    }


}
