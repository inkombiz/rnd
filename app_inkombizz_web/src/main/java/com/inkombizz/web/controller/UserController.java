package com.inkombizz.web.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.inkombizz.web.config.BaseSession;
import com.inkombizz.web.repository.UserRepository;
import com.inkombizz.web.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> listAllUsers(@RequestBody UserRepository model) {

		String REST_SERVICE_URL = "http://localhost:8181";
		String restUrl = REST_SERVICE_URL + "/v1/oauth/login";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserRepository> request = new HttpEntity<UserRepository>(model,httpHeaders);

		ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(restUrl, request, String.class);
		
		httpHeaders = responseEntityStr.getHeaders();
		String token =  httpHeaders.getFirst("Authorization");
		BaseSession sess = new BaseSession();
		sess.setToken(token);
		sess.setUserName(model.getUsername());
		return new ResponseEntity<>(token, HttpStatus.OK);
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public ResponseEntity<String> getSessionString(HttpServletRequest request) {
		BaseSession sess = (BaseSession)request.getSession();
		return new ResponseEntity<>(sess.getToken(), HttpStatus.OK);
	}
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserRepository> getUser(@PathVariable("id") long id) {
//		UserRepository model = userService.getUser(id);
//		if (model == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(model, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
//	public ResponseEntity<UserRepository> createUser(@RequestBody UserRepository model) {
//		UserRepository user = userService.createUser(model);
//
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<UserRepository> deleteUser(@PathVariable("id") long id) {
//		UserRepository user = userService.getUser(id);
//
//		if (user == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		userService.deleteUser(id);
//
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
}