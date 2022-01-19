package com.project.rest;

import com.project.rest.entity.UserInfoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApplicationTests {



	@LocalServerPort
	int randomServerPort;

	@Test
	public void testAdduserSuccess() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/user";
		URI uri = new URI(baseUrl);
		UserInfoEntity user = new UserInfoEntity();

		user.setUserName("ramkumar");
		user.setFirstName("ram");
		user.setLastName("kumar");
		user.setMobileNumber("5446465");
		user.setEmailID("ra@gmail.com");
		user.setAddress1("dubai");
		user.setAddress2("saudi");



		HttpEntity<UserInfoEntity> request = new HttpEntity<>(user);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

		//Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

}
