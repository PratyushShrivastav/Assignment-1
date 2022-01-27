package com.project.rest.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "userinfo")
@Getter
@Setter
public class UserInfoEntity {
    @Id

    private int id;


  //  @NotBlank
    //@Length(min = 8,max=15,message = "username should be between 8 and 15 words")
    @Column(name = "userName")
    private String userName;


    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mobileNumber")
    private String mobileNumber;
    @Column(name = "emailID")
    private String emailID;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;


}
