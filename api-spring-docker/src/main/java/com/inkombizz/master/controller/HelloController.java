package com.inkombizz.master.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {
	
	@RequestMapping(value = "/v1", method = RequestMethod.GET)
	public String test() {
		return "docker api-inkombizz-master is up and running: " + new Date();
	}

}
