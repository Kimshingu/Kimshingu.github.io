package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cart;
import com.example.demo.dto.Product;
import com.example.demo.repository.CartMapper;
import com.example.demo.repository.ProductMapper;

@RestController
public class CartController {
	@Autowired
	public CartMapper C_mapper;
	@Autowired
	public ProductMapper P_mapper;
	
	
	
	
	@PostMapping("/cart")
	public Object postCart(@RequestBody Cart cart) {
		return C_mapper.insert(cart);
	}
	
	@GetMapping("/cart")
	public Object getCart(@RequestParam(value="id") String user_email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cart", C_mapper.selectAll(user_email));
		List<Product> list = new ArrayList<>();
		
		for (Cart cart : C_mapper.selectAll(user_email)) {
			int id = cart.getProduct_id();
			list.add(P_mapper.searchById(id));
		}
		map.put("product", list);
		
		
		return map;
	}
	
	
}