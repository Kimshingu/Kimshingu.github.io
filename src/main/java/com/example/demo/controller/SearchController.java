package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductMapper;

@RestController
public class SearchController {
	
	@Autowired
	ProductMapper mapper;
	
	
	@GetMapping("/search")
	public Object postSearch(@RequestParam(value="kwd") String kwd) {
		if(kwd.equals("")) {
			return null;
		}
		List<Product> result = mapper.searchAll(kwd); 
		return result;
	} 
}
