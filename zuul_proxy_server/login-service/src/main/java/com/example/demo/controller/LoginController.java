package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public Login getCredential(@RequestBody Login login) {
		return loginService.getCredential(login);
	}
}
