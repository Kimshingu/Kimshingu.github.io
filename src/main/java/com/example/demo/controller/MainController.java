package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.repository.ProductMapper;

@RestController
public class MainController {

	@Autowired
	public ProductMapper mapper;

	@GetMapping("/getproduct")
	public Object getMainProduct() {

		int productMax = mapper.countAll();
		List<Product> list = new ArrayList<>();
		Random rd = new Random();

		while (list.size() < 8) { // 리스트의 길이가 8이 될때까지 반복
			int id = rd.nextInt(productMax) + 1; // 랜덤으로 제품번호 하나를 추첨
			
			// 해당 제품번호가 리스트에 포함되어있지 않다면 리스트에 추가
			if (!list.contains(mapper.searchById(id))) { 
				list.add(mapper.searchById(id));
			}
		}
		
		// 8개의 제품이 모두 추첨된 후 리스트를 리턴
		return list;

	}
}
