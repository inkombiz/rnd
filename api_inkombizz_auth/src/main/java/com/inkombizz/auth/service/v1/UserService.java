package com.inkombizz.auth.service.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserService {

	private String user_code;
	
	private String user_username;
	
	private String user_email;
	
	private String user_role_code;
	
	private String user_role_name;

}
