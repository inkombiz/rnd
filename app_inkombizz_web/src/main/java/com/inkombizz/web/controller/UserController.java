package com.inkombizz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.web.config.BaseSession;
import com.inkombizz.web.service.UserService;

import lombok.Getter;
import lombok.Setter;

@RestController
public class UserController {

	@Autowired
	private BaseSession baseSession;
	
	@Getter @Setter
	private UserService userService;

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public ResponseEntity<String> getSessionString(HttpServletRequest request) {
		return new ResponseEntity<>(baseSession.getToken(), HttpStatus.OK);
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