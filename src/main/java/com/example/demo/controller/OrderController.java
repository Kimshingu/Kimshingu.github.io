package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@PostMapping("/order")
	public Object postOrder() {
		return null;
	}
}
