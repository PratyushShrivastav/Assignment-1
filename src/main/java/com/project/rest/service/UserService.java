package com.project.rest.service;


import com.project.rest.entity.UserInfoEntity;

import com.project.rest.exception.ResourceAlreadyExistsException;
import com.project.rest.exception.ResourceNotFoundException;
import com.project.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity getUser(int userId) {

        UserInfoEntity getuserdetails = userRepository.findById(userId);


        if (getuserdetails == null)
            throw new ResourceNotFoundException("No user present with the id " + userId);


        return new ResponseEntity(getuserdetails, HttpStatus.OK);

    }

    public ResponseEntity postUser(UserInfoEntity user) {

        if (userRepository.findByuserName(user.getUserName()) != null || userRepository.findBymobileNumber(user.getMobileNumber()) != null || userRepository.findByemailID(user.getEmailID()) != null)
            throw new ResourceAlreadyExistsException("The user already exists");


        userRepository.save(user);
        return new ResponseEntity("Successfully added user to the database", HttpStatus.CREATED);


    }


    public ResponseEntity putUser(int userId, UserInfoEntity user) {
        UserInfoEntity updateuser = userRepository.findById(userId);


        if (updateuser == null)
            throw new ResourceNotFoundException("No user present with id " + userId);

        if (userRepository.findByuserName(user.getUserName()) != null || userRepository.findBymobileNumber(user.getMobileNumber()) != null || userRepository.findByemailID(user.getEmailID()) != null)
            throw new ResourceAlreadyExistsException("The user already exists");


        updateuser.setUserName(user.getUserName());
        updateuser.setFirstName(user.getFirstName());
        updateuser.setLastName(user.getLastName());
        updateuser.setMobileNumber(user.getMobileNumber());
        updateuser.setEmailID(user.getEmailID());
        updateuser.setAddress1(user.getAddress1());
        updateuser.setAddress2(user.getAddress2());


        userRepository.save(updateuser);
        return new ResponseEntity("Successfully added the information to your database", HttpStatus.OK);


    }

    public ResponseEntity deleteDetails(int userId) {


        UserInfoEntity deleteuser = userRepository.findById(userId);

        if (deleteuser == null)
            throw new ResourceNotFoundException("No user present with id " + userId);

        userRepository.delete(deleteuser);
        return new ResponseEntity("successfully deleted information from the database", HttpStatus.OK);


    }
}
