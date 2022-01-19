package com.project.rest.service;


import com.project.rest.entity.UserInfoEntity;
import com.project.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity getuser(int userId) {
           try {
               UserInfoEntity getuserdetails = userRepository.findById(userId);
               if(getuserdetails==null)
                   return new ResponseEntity("No such user exists",HttpStatus.NOT_FOUND);

                   else
               return new ResponseEntity(getuserdetails,HttpStatus.OK);
           }



           catch (Exception e) {
               return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
           }

    }

    public ResponseEntity postuser(UserInfoEntity user) {
        try {
            userRepository.save(user);
            return new ResponseEntity("Successfully added user to the database", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {

            return new ResponseEntity("user already exists", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public ResponseEntity putuser(int userId, UserInfoEntity user) {
        try {
        UserInfoEntity updateuser = userRepository.findById(userId);


        if (updateuser == null)
            return new ResponseEntity("user does not exist", HttpStatus.NOT_FOUND);

        updateuser.setUserName(user.getUserName());
        updateuser.setFirstName(user.getFirstName());
        updateuser.setLastName(user.getLastName());
        updateuser.setMobileNumber(user.getMobileNumber());
        updateuser.setEmailID(user.getEmailID());
        updateuser.setAddress1(user.getAddress1());
        updateuser.setAddress2(user.getAddress2());


            userRepository.save(updateuser);
            return new ResponseEntity("Successfully added the information to your database",HttpStatus.OK);



        } catch (DataIntegrityViolationException e) {

            return new ResponseEntity("User with this information already exists",HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity deletedetails(int userId) {

        try {


            UserInfoEntity deleteuser = userRepository.findById(userId);

            if (deleteuser == null)
                return new ResponseEntity("user does not exist", HttpStatus.NOT_FOUND);

            userRepository.delete(deleteuser);

            return new ResponseEntity("succesfully deleted information from the database", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
