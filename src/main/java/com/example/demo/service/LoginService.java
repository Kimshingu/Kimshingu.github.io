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
		// 브라우저에서 받아온 password를 암호화 한다.
		inputUser.setPassword(service.encryptPassword(inputUser.getPassword()));
		// 디비에서 selectOne(브라우저에서 받아온 email) 리턴 User 객체를 dbUser가 참조한다.
		User dbUser = usermapper.selectOne(inputUser.getEmail());
		
		// 디비와 브라우저의 password를 비교한다.
		// 성공시 "success"를 리턴한다.
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
