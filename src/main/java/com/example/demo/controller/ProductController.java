package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductMapper;

@RestController
public class ProductController {
	
	@Autowired
	ProductMapper mapper;
	
	
	@GetMapping("/product")
	public Object postSearch(@RequestParam(value="id") int id) {
		Product result = mapper.searchById(id); 
		return result;
	} 
}
