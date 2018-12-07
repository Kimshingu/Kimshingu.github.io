package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Product;


@Mapper
public interface ProductMapper {
	
	public List<Product> searchAll(String name);
	public Product searchById(int id);
	public int countAll();
	public List<Product> findByPageSizeUsingBind(int page, int size);
	
}
