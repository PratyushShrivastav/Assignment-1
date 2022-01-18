package com.project.rest.service;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserInfoEntity getuser(int userId) {

        UserInfoEntity getuserdetails = userRepository.findById(userId);
        return getuserdetails;
    }

    public String postuser(UserInfoEntity user) {
        try {
            userRepository.save(user);
            return "Successfully added your information to database";
        } catch (DataIntegrityViolationException e) {

            return "User already exists";
        } catch (Exception e) {
            return e.getMessage();
        }

    }


    public String putuser(int userId, UserInfoEntity user) {

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

        try {
            userRepository.save(updateuser);
            return "Successfully updated your information to database";
        } catch (DataIntegrityViolationException e) {

            return "Cannot update the information ,User with this information already exists";
        }


    }

    public String deletedetails(int userId) {

        UserInfoEntity deleteuser = userRepository.findById(userId);

        if (deleteuser == null)
            return "No such user exists";

        userRepository.delete(deleteuser);

        return "Successfully deleted the information from database";


    }
}
