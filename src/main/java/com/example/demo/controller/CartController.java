package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	// URL : /cart 일때 cart 테이블에 insert(INSERT INTO 문과 함께 VALUES 절을 사용하여 
	// 해당 테이블에 새로운 레코드를 추가할 수 있습니다.) 하겠다.
	// post요청방식으로 mapping 하겠다.
	@PostMapping("/cart")
	public Object postCart(@RequestBody Cart cart) {
		return C_mapper.insert(cart);
	}
	
	// cart 리스트와 cart 리스트에 일치하는 product 리스트를 리턴한다.
	@GetMapping("/cart")
	public Object getCart(@RequestParam(value="id") String user_email) {
		Map<String,Object> map = new HashMap<>();
		List<Object> list = new ArrayList<>();
		map.put("cart", C_mapper.selectAll(user_email));
		
		for (Cart cart : C_mapper.selectAll(user_email)) {
			int id = cart.getProduct_id();
			Product product = P_mapper.searchById(id);
			list.add(product);
		}
		
		map.put("product", list);
		
		return map;
	}
	
	@DeleteMapping("/cart")
	public void deleteCart(@RequestBody Cart cart) {
		C_mapper.delete(cart);
	}
}
