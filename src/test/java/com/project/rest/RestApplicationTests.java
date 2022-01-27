package com.project.rest;

import com.project.rest.entity.UserInfoEntity;
import com.project.rest.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApplicationTests {


    @Autowired
	UserRepository userRepository;

	@Test
	public void testAddUser()
	{

		UserInfoEntity addUser= new UserInfoEntity();

		addUser.setUserName("shyamkumar");
		addUser.setFirstName("shyam");
		addUser.setLastName("kumar");
		addUser.setMobileNumber("8085021987");
		addUser.setEmailID("shyam123@gmail.com");
		addUser.setAddress1("India");
		addUser.setAddress2("bangladesh");

		userRepository.save(addUser);

        Assertions.assertNotNull(addUser);

		//Verify request succeed
		//Assertions.assertEquals("user already exists", result.getBody());
		//System.out.println(result.getStatusCode());
	}

    @Test
	public void testFindUserExist()
	{
		int id=61;

		UserInfoEntity findUser = userRepository.findById(id);

		Assertions.assertEquals(findUser.getId(),id);
	}
	@Test
	public void testFindUserNotExist()
	{
          int id=99;
		UserInfoEntity findUser = userRepository.findById(id);

		Assertions.assertNull(findUser);

	}
	@Test
	public void testUpdateUser()
	{
		int id=61;

		UserInfoEntity updateUser= userRepository.findById(id);

		String name= "shyamkumari";

		updateUser.setUserName(name);
		updateUser.setFirstName("shyam");
		updateUser.setLastName("kumar");
		updateUser.setMobileNumber("85021987");
		updateUser.setEmailID("shyamkumari123@gmail.com");
		updateUser.setAddress1("India");
		updateUser.setAddress2("bangladesh");

        userRepository.save(updateUser);

		UserInfoEntity updatedUser= userRepository.findById(id);


		Assertions.assertEquals(name,updatedUser.getUserName());



	}



	@Test
	public void testDeleteUser()
	{

		   String name= "pig456hbj@gmail.com";
           UserInfoEntity deleteUser= userRepository.findByemailID(name);

		   userRepository.delete(deleteUser);

		   UserInfoEntity deleteduser=userRepository.findByemailID(name);

           Assertions.assertNull(deleteduser);


	}









}
