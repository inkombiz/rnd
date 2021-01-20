package com.inkombizz.web.config;

import lombok.Data;

@Data
public class Session {
	boolean session = false;
	String token = null;
	String userName = null;
	String userEmail = null;
	String loginDate = null;
}
