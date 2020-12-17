package com.inkombizz.web.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("session")
@SessionAttributes("BaseSession")
@Getter
@Setter
public class BaseSession {
	String token = null;
	String userName = null;
	String userEmail = null;
	String loginDate = null;
}
