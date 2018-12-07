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

		for (int i = 0; i < 8; i++) {
			int id = rd.nextInt(productMax) + 1;
			list.add(mapper.searchById(id));
		}

		return list;

	}
}
