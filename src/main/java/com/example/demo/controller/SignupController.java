package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.SignupService;

@RestController
public class SignupController {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private SignupService signupservice;
	
	@GetMapping("/signup")
	public Object isValidAccount(@RequestParam(value="email") String email) {
		User user = usermapper.selectOne(email);
		if(user!=null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}


	@PostMapping("/signup")
	public Object postSingup(@RequestBody User user, HttpSession session, Model model) {
		user.setPassword(signupservice.encryptPassword(user.getPassword()));
		usermapper.insert(user);
		return user;
	}

}
