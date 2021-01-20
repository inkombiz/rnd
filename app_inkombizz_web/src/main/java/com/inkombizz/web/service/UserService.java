package com.inkombizz.web.service;

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.inkombizz.web.repository.UserRepository;

public class UserService {

	private final String REST_SERVICE_URL = "http://localhost:8181";

	private static HttpHeaders getHeaders() {
		String adminuserCredentials = "mradmin:mradmin";
		String encodedCredentials = new String(Base64.encodeBase64(adminuserCredentials.getBytes()));

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic " + encodedCredentials);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return httpHeaders;
	}

	public String getLoginToken(String username, String password) {
		String restUrl = REST_SERVICE_URL + "/v1/oauth/login";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders(getHeaders());

		UserRepository model = new UserRepository();
		model.setUsername(username);
		model.setPassword(password);
		HttpEntity<UserRepository> request = new HttpEntity<UserRepository>(model,httpHeaders);

		ResponseEntity<String> responseEntityStr = restTemplate.postForEntity(restUrl, request, String.class);
		
		httpHeaders = responseEntityStr.getHeaders();
		return httpHeaders.getFirst("Authorization");
	}
}
