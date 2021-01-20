package com.inkombizz.web.config;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

public class BaseControllers {

	@Autowired
	@Getter @Setter
	private BaseSession baseSession;
}
