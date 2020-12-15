package com.inkombizz.auth.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inkombizz.auth.util.Response;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String,String> errors = new HashMap<>();
		List<ObjectError> oe = ex.getBindingResult().getAllErrors();
		
		for (ObjectError err : oe) {
			String field = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			errors.put(field, message);
		}
		Response r = new Response();
				 r.response_json(false,"Validation",errors,HttpStatus.INTERNAL_SERVER_ERROR);
		return super.handleExceptionInternal(ex, r, headers, status, request);
	}
	
}
