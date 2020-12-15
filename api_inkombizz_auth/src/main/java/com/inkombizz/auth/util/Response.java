package com.inkombizz.auth.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	private boolean status = true;
	private String message = null;
	private Object data = null;
	
	public ResponseEntity<?> response_json (boolean status,String message, Object data, HttpStatus code){
		this.status = status;
		this.message = message;
		this.data = data;
		return new ResponseEntity<Response>(this,code);
	}
}
