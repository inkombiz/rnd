package com.inkombizz.auth.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inkombizz.auth.util.ConvertCurrency;

@RestController
public class IndexControllers {
	
	@RequestMapping("/")
	public String index() {
		return "api-inkombizz-master is running.";
	}

	@RequestMapping("/api")
	public String index_api() {
		return "api-inkombizz-master is running.";
	}
	
	@RequestMapping("/api/v1")
	public String index_v1() {
		return "api-inkombizz-master is running.";
	}
}