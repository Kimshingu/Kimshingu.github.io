package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;
import com.example.demo.repository.UserMapper;

@Service
public class LoginService {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private SignupService service;
	
	public String loginAuthenticate(User inputUser) {
		inputUser.setPassword(service.encryptPassword(inputUser.getPassword()));
		User dbUser = usermapper.selectOne(inputUser.getEmail());
		
		
		if (dbUser == null) {
			return "null"; 
		} else if(!(dbUser.getPassword().equals(inputUser.getPassword()))){
			return "invalid";
		}else {
			inputUser = dbUser;
			return "success";
		}
	
	}
}
