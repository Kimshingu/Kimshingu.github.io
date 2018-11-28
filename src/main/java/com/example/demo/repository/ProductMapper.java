package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Product;


@Mapper
public interface ProductMapper {

	
	public List<Product> findAll(String name);
	public int count(String name);

	public List<Product> findByPageSizeUsingBind(int page, int size);
	
	
}
