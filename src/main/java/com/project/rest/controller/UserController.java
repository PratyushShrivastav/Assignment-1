package com.project.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public String getUserDetails(@RequestParam int userId){

        System.out.println(userId);
        return "hey";
    }

    @GetMapping("/testapiUser")
    public String helloUser(){
        return "hey";
    }
}
