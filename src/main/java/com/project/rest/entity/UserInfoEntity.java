package com.project.rest.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "userinfo")
@Getter
@Setter
public class UserInfoEntity {
    @Id

    private int id;



    @Length(min = 5,max=15,message = "username should be between 5 and 15 characters")
    @Column(name = "userName")
    private String userName;

    @Length(min = 5,max=15,message = "firstname should be between 5 and 15 characters")
    @Column(name = "firstName")
    private String firstName;

    @Length(min = 5,max=15,message = "lastname should be between 5 and 15 characters")
    @Column(name = "lastName")
    private String lastName;


    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Email(message = "emailid should be valid")
    @Column(name = "emailID")
    private String emailID;


    @Length(max=50,message = "address should not exceed 50 characters")
    @Column(name = "address1")
    private String address1;

    @Length(max=50,message = "address should not exceed 50 characters")
    @Column(name = "address2")
    private String address2;


}
