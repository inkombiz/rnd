package com.inkombizz.web.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
//
//	public List<UserRepository> listAllUsers() {
//		System.out.println("Getting all users");
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders httpHeaders = getHeaders();
//
//		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
//
//		ResponseEntity<List> responseEntity = restTemplate.exchange(REST_SERVICE_URL, HttpMethod.GET, httpEntity,
//				List.class);
//
//		if (responseEntity.hasBody()) {
//			List<UserRepository> users = responseEntity.getBody();
//			if (users != null) {
//				return users;
//			}
//		}
//
//		return null;
//
//	}
//
//	public void getUser(long id) {
//		System.out.println("Getting a user ");
//
//		String restUrl = REST_SERVICE_URL + id;
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		HttpHeaders httpHeaders = getHeaders();
//
//		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
//
//		ResponseEntity<String> responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET, httpEntity,
//				String.class);
//
//		if (responseEntity.hasBody()) {
//			JSONObject jsonObject = new JSONObject(responseEntity.getBody());
//
//			System.out.println(jsonObject.get("firstname"));
//			System.out.println(jsonObject.get("lastname"));
//		} else {
//			System.out.println("User not found");
//		}

//	}
}
