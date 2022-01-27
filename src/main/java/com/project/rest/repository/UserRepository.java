package com.project.rest.repository;

import com.project.rest.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfoEntity, Integer> {


    UserInfoEntity findById(int id);
    public UserInfoEntity findByuserName(String username);
    public UserInfoEntity findBymobileNumber(String mobilenumber);
    public UserInfoEntity findByemailID(String emailid);



}


