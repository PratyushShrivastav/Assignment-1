package com.project.rest.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "userinfo")
@Getter
@Setter
public class UserInfoEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="userName")
    private String userName;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="mobileNumber")
    private String mobileNumber;
    @Column(name="emailID")
    private String emailID;
    @Column(name="address1")
    private String address1;
    @Column(name="address2")
    private String address2;


}
