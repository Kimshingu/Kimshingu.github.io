package com.example.demo.service;

import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class SignupService {

	public String encryptPassword(String password) {
		String result = "";

		try {
			MessageDigest diget = MessageDigest.getInstance("SHA-256");
			diget.update(password.getBytes());
			byte[] byteData = diget.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			result = sb.toString();
		} catch (Exception e) {
			e.getMessage();
		}

		return result;
	}

}
