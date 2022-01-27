package com.project.rest.controller;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.exception.ResourceAlreadyExistsException;
import com.project.rest.exception.ResourceNotFoundException;
import com.project.rest.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping("/user")
    public ResponseEntity getUserDetails(@RequestParam int userId) throws Exception {


        try {
            return userservice.getUser(userId);
        }
        catch(ResourceNotFoundException e)
        {
             throw new ResourceNotFoundException(e.getMessage());
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }



    }



    @PostMapping("/user")
    public ResponseEntity insertUserDetails( @RequestBody UserInfoEntity user) throws Exception {

        try {
            return userservice.postUser(user);
        }
        catch(ResourceAlreadyExistsException e) {

            throw new ResourceAlreadyExistsException(e.getMessage());

        }
        catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }


    }

    @PutMapping("/user")
    public ResponseEntity updateuserdetails(@RequestParam int userId, @RequestBody UserInfoEntity user) throws Exception {

        try {
            return userservice.putUser(userId, user);
        }
        catch(ResourceNotFoundException e)
        {
            throw new ResourceNotFoundException(e.getMessage());
        }
        catch(ResourceAlreadyExistsException e) {

            throw new ResourceAlreadyExistsException(e.getMessage());

        }

        catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @DeleteMapping("/user")
    public ResponseEntity deleteuserdetails(@RequestParam int userId) throws Exception {

        try {
            return userservice.deleteDetails(userId);
        }
        catch(ResourceNotFoundException e)
        {
            throw new ResourceNotFoundException(e.getMessage());
        }
        catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }

    }


}
