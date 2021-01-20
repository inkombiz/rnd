package com.inkombizz.web.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.inkombizz.web.config.BaseControllers;
import com.inkombizz.web.repository.UserRepository;
import com.inkombizz.web.service.UserService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class LoginController extends BaseControllers{
	
	@Getter @Setter
	private UserService userService;
	
	@PostMapping(path = "/login", consumes = "application/x-www-form-urlencoded")
	public String login(UserRepository model) {
		
		if(getBaseSession().isSession()) {
			return "redirect:/authenticate";	
		}

		String REST_SERVICE_URL = "http://localhost:8181";
		String loginUrl = REST_SERVICE_URL + "/v1/oauth/login";
		String restUrlData = REST_SERVICE_URL + "/v1/user/001";
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserRepository> request = new HttpEntity<UserRepository>(model,httpHeaders);
	    
	    ResponseEntity<String> response = new RestTemplate().exchange(loginUrl, HttpMethod.POST, request, String.class);
		httpHeaders = response.getHeaders();
		
		getBaseSession().setSession(true);
		getBaseSession().setToken(httpHeaders.getFirst("Authorization"));
		getBaseSession().setUserName(model.getUsername());

		
//		httpHeaders.add("Authorization", getBaseSession().getToken());
//		HttpEntity auth = new HttpEntity(httpHeaders);
//	    response = new RestTemplate().exchange(restUrlData, HttpMethod.GET, auth, String.class);
//	    
//		getBaseSession().setUserEmail(response.getBody().valueOf("email"));
		
		return "redirect:/authenticate";
	}
	
	@GetMapping("/logout")
    public String logout() {        
		
        if(getBaseSession().isSession()) {
            getBaseSession().setSession(false);	
		}
          
        return "redirect:/authenticate";
    }
}
