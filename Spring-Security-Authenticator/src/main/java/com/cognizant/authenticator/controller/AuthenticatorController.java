package com.cognizant.authenticator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatorController {
	
	@GetMapping
	public String authenticate() {
		return "You have been authenticated, now you can use your RESTful webservice";
	}
	
}
