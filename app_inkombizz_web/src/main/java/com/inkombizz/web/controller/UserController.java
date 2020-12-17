package com.inkombizz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.web.repository.UserRepository;
import com.inkombizz.web.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<UserRepository>> listAllUsers() {
		List<UserRepository> users = userService.listAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserRepository>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(users, HttpStatus.OK);
	}
//
//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserRepository> getUser(@PathVariable("id") long id) {
//		UserRepository userDto = userService.getUser(id);
//		if (userDto == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(userDto, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
//	public ResponseEntity<UserRepository> createUser(@RequestBody UserRepository userDto) {
//		UserRepository user = userService.createUser(userDto);
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