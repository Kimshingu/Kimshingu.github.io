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
	
	// /search?kwd='입력한 검색어'의 값을 받는다.
	@GetMapping("/search")
	public Object postSearch(@RequestParam(value="kwd") String kwd) {
		if(kwd.equals("")) {
			return null;
		}
		// '입력한 검색어'로 select 문을 수행한 후 product 객체를 list로 담는다.
		List<Product> result = mapper.searchAll(kwd); 
		return result;
	} 
}
