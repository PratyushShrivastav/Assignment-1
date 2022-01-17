package com.project.rest.controller;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public UserInfoEntity getUserDetails(@RequestParam int userId) {

        //System.out.println(userId);


        UserInfoEntity getuser = userRepository.findById(userId);

        return getuser;
    }


    @PostMapping("/user")
    public String insertUserDetails(@RequestBody UserInfoEntity user) {


        //userRepository.findByuser.getEmailID()
        try {
            userRepository.save(user);
            return "Successfully added your information to database";
        } catch (DataIntegrityViolationException e) {

            return "User already exists";
        } catch (Exception e) {
            return e.getMessage();
        }


        //System.out.println(userId);

    }

    @PutMapping("/user")
    public String updateuserdetails(@RequestParam int userId, @RequestBody UserInfoEntity user) {
        UserInfoEntity updateuser = userRepository.findById(userId);


        if (updateuser == null)
            return "No such user exists";

        updateuser.setUserName(user.getUserName());
        updateuser.setFirstName(user.getFirstName());
        updateuser.setLastName(user.getLastName());
        updateuser.setMobileNumber(user.getMobileNumber());
        updateuser.setEmailID(user.getEmailID());
        updateuser.setAddress1(user.getAddress1());
        updateuser.setAddress2(user.getAddress2());


        userRepository.save(updateuser);
        return "Successfully updated your information to database";
    }

    @DeleteMapping("/user")
    public String deleteuserdetails(@RequestParam int userId) {
        UserInfoEntity deleteuser = userRepository.findById(userId);

        if (deleteuser == null)
            return "No such user exists";

        userRepository.delete(deleteuser);

        return "Successfully deleted the information from database";
    }


}
