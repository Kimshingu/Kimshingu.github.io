package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@Autowired
	private UserMapper mapper;

	
	
	@PostMapping("/login")
	public Object postLogin(@RequestBody User user) {
		/*
		 loginservice.loginAuthenticate(user) return 값이 success일 경우,
		 브라우저에서 가져온 email, password와 
		 디비에서 selectOne(email)로 이름, 전화번호, 주소를 가져와 
		 User 객체를 만든다.
		*/
		if (loginservice.loginAuthenticate(user).equals("success")) {
			User passUser = new User(user.getEmail(), user.getPassword(), 
					mapper.selectOne(user.getEmail()).getName(),
					mapper.selectOne(user.getEmail()).getPhone(), 
					mapper.selectOne(user.getEmail()).getAddress());
			return passUser;
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}

}
